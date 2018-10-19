package com.panther.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class LoginController {

    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            //登陆成功 ,防止表单重复提交，重定向
            session.setAttribute("user","username");
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名密码错误");
            return "/resources/login";
        }

    }
}
