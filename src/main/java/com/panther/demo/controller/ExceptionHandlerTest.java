package com.panther.demo.controller;

import com.panther.demo.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerTest {

    //捕获异常，然后进行处理。（浏览器和客户端都返回JSON数据）
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handlerException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","userNotExist");
//        map.put("message",e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        /**
         *  需要自定义错误状态码
         *  Integer statusCode = (Integer) request
         *                 .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","userNotExist");
        map.put("message","用户不存在！！！");
        request.setAttribute("ext",map);
        //  转发到/error  达到自适应效果（浏览器展示页面，客户端显示JSON数据）
        return "forward:/error";
    }


}
