package com.example.pm.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        //前端发送的请求路径中，后端中允许哪些路径可以被处理（简单来说：允许哪些RequestMapping的语句被执行）。/**表示：前端发送的所有请求路径，后端都可以执行
        registry.addMapping("/**")
                .allowedHeaders("*")//前端发送的请求中，允许任意请求头访问
                .allowedOrigins("http://localhost:8080")//前端发送的请求中，允许域名为http://localhost:8080访问
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE")//前端发送的请求中,允许请求方式"GET","POST","PUT","OPTIONS","DELETE"访问
                .allowCredentials(true)//前端发送的请求中，允许前端携带证书来访问
                //预检请求的最大时间,如果预检请求访问消耗的时间超过最大时间,就重新发送预检请求;
                //预检请求就是在真正的请求发送前,向后端发送的一个前置检查请求，这个请求中携带域名、请求方式、请求头;
                //根据预检请求所收到的响应信息,来判断是否真的要发送真正的请求。
                .maxAge(3600);
    }

    public List<String> excludePattern(){
        List<String> ret = new ArrayList<String>();

        return ret;
    }
}