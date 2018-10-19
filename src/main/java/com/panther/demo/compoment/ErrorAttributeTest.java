package com.panther.demo.compoment;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//给容器添加自己的ErrorAttributes,可以自定义数据
@Component
public class ErrorAttributeTest extends DefaultErrorAttributes {

    //返回的map是页面和JSON 能获取到的数据
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","PantherTest");

        //异常处理器中携带的数据内容
        Map<String,Object> extMap = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext",extMap);
        return map;
    }
}
