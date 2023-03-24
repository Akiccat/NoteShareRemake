package com.akicat.noteshareremake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class NoteShareRemakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteShareRemakeApplication.class, args);
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("D:\\CatCode\\Season3\\NoteShareRemake\\src\\main\\resources\\static\\images\\");
        return factory.createMultipartConfig();
    }


}
