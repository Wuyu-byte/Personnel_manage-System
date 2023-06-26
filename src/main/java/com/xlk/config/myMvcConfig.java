package com.xlk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class myMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry ) {

        registry.addViewController("/ ").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path="D:/文档/Ideaworkpasce/springbootdemo01/src/main/resources/static/health/";
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+path);
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    //拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                new LoginHandlerInterceptor()).
                addPathPatterns("/**").excludePathPatterns("/captcha","/login","/user/login","/user/loginout",
                "/lib/**","/css/**","/images/**","/js/**","/api/**","/emplogin","/emplogin/login");
    }
}
