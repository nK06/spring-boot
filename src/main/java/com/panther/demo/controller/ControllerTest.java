package com.panther.demo.controller;


import com.panther.demo.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class ControllerTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @ResponseBody
    @RequestMapping("/hello")
    public String index(@RequestParam("user") String user){
        if("aa".equals(user)){
            throw new UserNotExistException();
        }
//        redisTemplate.opsForValue().set("abc"," [{'group':0,'param':['one','two','three']}]");
//        redisTemplate.opsForValue().set("bbb","33333");
        return "hello world!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("name","AA");
        map.put("users",Arrays.asList("AAA","BBB","CCC"));
        return "home/success";
    }
}
