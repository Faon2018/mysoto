package com.faon.controller;

import com.faon.entity.User;
import com.faon.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
//
//    @RequestMapping("/select")
//    @ResponseBody
//    public User  selectById(){
//       return userMapper.selectById();
//    }
//
//
    @RequestMapping("/test")
    public  String  test(Map<String,Object> map){
        User user =userServiceImpl.get();
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
}
