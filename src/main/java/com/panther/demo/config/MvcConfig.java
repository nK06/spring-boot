package com.panther.demo.config;

import com.panther.demo.compoment.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("resources/login");
        registry.addViewController("/index.html").setViewName("resources/login");
        registry.addViewController("/main.html").setViewName("resources/dashboard");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new loginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html","/","/user/login","/static/**","/webjars/**");
    }

    //静态资源拦截器
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new LocaleResolver();
    }

}
