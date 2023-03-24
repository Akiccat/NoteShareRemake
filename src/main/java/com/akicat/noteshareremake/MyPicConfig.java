package com.akicat.noteshareremake;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyPicConfig implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("配置文件已经生效");
        registry.addResourceHandler("/images/**").addResourceLocations("file:D:\\CatCode\\Season3\\NoteShareRemake\\src\\main\\resources\\static\\images\\");
    }
}
