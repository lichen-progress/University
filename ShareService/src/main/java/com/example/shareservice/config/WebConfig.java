package com.example.shareservice.config;

import com.example.shareservice.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//过滤器设置
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //对用户进行修改需要验证token
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/alert/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/file/**");

    }
}
