package com.example.hotel_booking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private String resoucePath = "src/main/uploads/**";
    private String savePath = "src/main/uploads/room";

    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry){
        registry.addResourceHandler(resoucePath)
                .addResourceLocations(savePath);

    }

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")  // 모든 경로에 대해 CORS 설정을 적용합니다
                .allowedOrigins("http://localhost:3000")  // 허용할 출처를 지정합니다
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 HTTP 메서드를 지정합니다
                .allowCredentials(true);  // 자격 증명이 포함된 요청을 허용합니다
    }
}/**/
