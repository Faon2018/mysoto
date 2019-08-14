package com.faon.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(@Value("${shiro.hashAlgorithmName}") String hashAlgorithmName,
                                                             @Value("${shiro.hashIterations}") int hashIterations ) {
        HashedCredentialsMatcher credentialsMatcher =
                new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName(hashAlgorithmName);
        //加密次数
        credentialsMatcher.setHashIterations(hashIterations);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean("shiroRealm")
    public Realm shiroRealm(@Qualifier("hashedCredentialsMatcher")
                                       HashedCredentialsMatcher matcher) {

        ShiroRealm userRealm = new ShiroRealm();
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager")
                                                     DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置 SecurityManager
        bean.setSecurityManager(securityManager);
        // 设置登录成功跳转Url
        bean.setSuccessUrl("/main");
        // 设置登录跳转Url
//        bean.setLoginUrl("/toLogin");
        // 设置未授权提示Url
        bean.setUnauthorizedUrl("/error/unAuth");

        /**
         * anon：匿名用户可访问
         * authc：认证用户可访问
         * user：使用rememberMe可访问
         * perms：对应权限可访问
         * role：对应角色权限可访问
         **/
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login","anon");
        filterMap.put("/register","anon");
        filterMap.put("/user/index","authc");
        filterMap.put("/vip/index","roles[vip]");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/static/**","anon");

        filterMap.put("/logout", "logout");
        //过滤掉静态资源
        filterMap.put("/node_modules/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/css/**","anon");
        filterMap.put("/fonts/**","anon");
        filterMap.put("/**","authc");

        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    /**
     * 注入 securityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(
            HashedCredentialsMatcher hashedCredentialsMatcher) {

        DefaultWebSecurityManager securityManager =
                new DefaultWebSecurityManager();
        // 关联realm.
        securityManager.setRealm(shiroRealm(hashedCredentialsMatcher));
        return securityManager;
    }

}
