package com.faon.controller;


import com.faon.entity.Result;
import com.faon.entity.User;
import com.faon.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Value("${shiro.hashAlgorithmName}")
    private String hashAlgorithmName;
    @Value("${shiro.hashIterations}")
    private int hashIterations;
//
//    @RequestMapping("/select")
//    @ResponseBody
//    public User  selectById(){
//       return userMapper.selectById();
//    }
//
//
    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,@RequestParam("state") String state){
        System.out.println(code);
        System.out.println(state);
        return  "redirect:/index";
    }
    @RequestMapping("/test")
    public  String  test(Map<String,Object> map){
        User user =userServiceImpl.getUserByName("dsd");
        map.put("name", "Joe");
        map.put("sex", 1);    //sex:性别，1：男；0：女；
        map.put("test","test");
        // 模拟数据
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "xbq");
        friend.put("age", 22);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "July");
        friend.put("age", 18);
        friends.add(friend);
        map.put("friends", friends);
        map.put("user", user);
//        return "freemarker";
        return "components/header";
    }
    @RequestMapping("/abc")
    public String  test(){
        return  "register";
    }

    @RequestMapping("/index")
    public String  main(Model model){
        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        User principal = (User)subject.getPrincipal();
        model.addAttribute("user",principal);
        return  "index";
    }

    @RequestMapping("/login")
    public  String  login(@RequestParam( value = "username",required = false) String username, @RequestParam(value = "password",required = false) String password, Model model){
        model.addAttribute("msg","");
        return loginVerify(username,password,model,"login");
    }

    @RequestMapping("/register")
    public  String  register(@RequestParam(value = "username",required = false) String username, @RequestParam(value = "password",required = false) String password, Model model){
        model.addAttribute("msg","");
            if (!StringUtils.isEmpty(username)){
                User user = userServiceImpl.getUserByName(username);
                if (user != null){//用户注册
                    model.addAttribute("msg","用户名已被使用！");
                    username=null;
                }else {
                    Boolean aBoolean = userServiceImpl.addUser(passwordEncryption(username, password));
                    if (!aBoolean){
                        model.addAttribute("msg","注册失败！");
                    }
                }
            }

//        return   loginVerify(username,password,model,"register");
        return   loginVerify(username,password,model,"register");//密码要是加密后的密码
    }


    /**
     * 注册时密码加密
     * @param username
     * @param password
     * @return
     */
    public User passwordEncryption(String username,String password){
            ByteSource credentialsSalt = ByteSource.Util.bytes(username);
            Object obj = new SimpleHash(hashAlgorithmName, password, credentialsSalt, hashIterations);
        return  new User(username,obj.toString());
    }



    /**
     *
     * 登录验证
     * @param username
     * @param password
     * @param model
     * @param view
     * @return
     */

    public String   loginVerify(String username,String password,Model model,String view){
        if(!StringUtils.isEmpty(username)){
            logger.info(username);
            logger.info(password);
            // 1.获取Subject
            Subject subject = SecurityUtils.getSubject();
            // 2.封装用户数据
//            UsernamePasswordToken token = new UsernamePasswordToken(username,passwordEncryption(username, password).getPassword());
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            // 3.执行登录方法
            try{
                subject.login(token);
                return "redirect:/index";
            } catch (UnknownAccountException e){
                System.out.println("用户名不存在！");
                model.addAttribute("msg","用户名不存在！");
            } catch (IncorrectCredentialsException e){
                System.out.println("密码错误！");
                model.addAttribute("msg","密码错误！");
            }
        }

        return view;
    }
//    @ResponseBody
//    @RequestMapping("/login")
//    public  Result  login(@RequestParam( value = "username",required = false) String username, @RequestParam(value = "password",required = false) String password, Model model){
//        model.addAttribute("msg","");
//        return loginVerify(username,password,model,"login");
//    }
//
//    @ResponseBody
//    public Result loginVerify(String username, String password, Model model, String view){
//        Result result=new Result();
//        if(!StringUtils.isEmpty(username)){
//            logger.info(username);
//            logger.info(password);
//            // 1.获取Subject
//            Subject subject = SecurityUtils.getSubject();
//            // 2.封装用户数据
////            UsernamePasswordToken token = new UsernamePasswordToken(username,passwordEncryption(username, password).getPassword());
//            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//            // 3.执行登录方法
//            try{
//                subject.login(token);
////                return "redirect:/index";
//                model.addAttribute("msg","登录成功！");
//                result.setMsg("登陆成功");
//                result.setCode(1);
//                result.setData(new User(username,password));
//            } catch (UnknownAccountException e){
//                System.out.println("用户名不存在！");
//                model.addAttribute("msg","用户名不存在！");
//                result.setMsg("用户名不存在");
//                result.setCode(-1);
//            } catch (IncorrectCredentialsException e){
//                System.out.println("密码错误！");
//                model.addAttribute("msg","密码错误！");
//                result.setMsg("密码错误");
//                result.setCode(-1);
//            }
//        }
//
//        return result;
//    }
}
