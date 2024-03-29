package com.faon.config;

import com.faon.entity.Permission;
import com.faon.entity.Role;
import com.faon.entity.User;
import com.faon.service.RoleService;
import com.faon.service.impl.PermissionServiceImpl;
import com.faon.service.impl.RoleServiceImpl;
import com.faon.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm  extends AuthorizingRealm {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl  roleServiceImpl;
    @Autowired
    private PermissionServiceImpl  permissionServiceImpl;

    /**
     * 用户授权
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {

        System.out.println("===执行授权===");

        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        if(user != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 角色与权限字符串集合
            Collection<String> rolesCollection = new HashSet<>();
            Collection<String> premissionCollection = new HashSet<>();
            // 读取并赋值用户角色与权限
            List<Role> roles = roleServiceImpl.getRolesByUserId(user.getId());
            for(Role role : roles){
                rolesCollection.add(role.getRole());
                List<Permission> permissions = permissionServiceImpl.getPermissionsByUserId(user.getId());
                for (Permission permission : permissions){
                    premissionCollection.add(permission.getPermission());
                }
                info.addStringPermissions(premissionCollection);
            }
            info.addRoles(rolesCollection);
            return info;
        }
        return null;
    }

    /**
     * 用户认证
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("===执行认证===");

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User bean = userService.getUserByName(token.getUsername());

        if(bean == null){
            throw new UnknownAccountException();
        }

        ByteSource credentialsSalt = ByteSource.Util.bytes(bean.getUsername());

        return new SimpleAuthenticationInfo(bean, bean.getPassword(),
                credentialsSalt, getName());
    }

    // 模拟Shiro用户加密，假设用户密码为123456
    public static void main(String[] args){
        // 用户名
        String username = "rhine";
        // 用户密码
        String password = "123456";
        // 加密方式
        String hashAlgorithName = "MD5";
        // 加密次数
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        Object obj = new SimpleHash(hashAlgorithName, password,
                credentialsSalt, hashIterations);
        System.out.println(obj);
    }

}
