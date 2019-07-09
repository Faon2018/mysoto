package com.faon.controller;


import com.faon.entity.Article;
import com.faon.service.impl.ArticleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ArticleServiceImpl  articleServiceImpl;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/index")
    public String index(){
        return  "components/article/index";
    }
    @RequestMapping("/add")
    public String add(@RequestBody Map<String,Object> map){
        if (map.containsKey("data")){
            Object obj=map.get("data");
            System.out.println(obj);
        }
        return  "components/article/index";
    }

    @RequestMapping(value = "/selectAll")
    public  String getAll(Model model){
        logger.info("日志使用成功");
        logger.error("错误日志");
        logger.warn("警告日志");
       List<Article> articles=new ArrayList<Article>();
        articles=(List<Article>) redisTemplate.opsForList().leftPop("map");

        if (articles==null){
            List<Article> lists=articleServiceImpl.getAll();
            System.out.println("缓存");
            Long t=redisTemplate.opsForList().leftPush("map",lists);
            if (t>0){
                System.out.println("缓存成功！");
            }
            model.addAttribute("map",lists);
        }else {
            System.out.println("获取缓存");
            model.addAttribute("map",articles);
        }
        return "components/index";
    }

    @RequestMapping(value = "/jsontest")
    @ResponseBody
    public  List<Article> test(){
        List<Article> lists=articleServiceImpl.getAll();

        return  lists;

    }
}
