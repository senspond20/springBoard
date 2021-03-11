package com.example.demo.common.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/board").setViewName("board");
        registry.addViewController("/board/vue").setViewName("boardVue");
        registry.addViewController("/board/posting").setViewName("posting");
        registry.addViewController("/about").setViewName("about");
       // WebMvcConfigurer.super.addViewControllers(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET","POST","PUT")
                .maxAge(3000);

        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
