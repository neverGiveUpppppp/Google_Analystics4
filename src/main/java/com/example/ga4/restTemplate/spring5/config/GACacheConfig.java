package com.example.ga4.restTemplate.spring5.config;

import com.google.gson.Gson;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration("GACacheConfig2")
public class GACacheConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) { // RestTemplateBuilder :  spring5 & SpringBoot 1.4 이상
        return builder
                .setConnectTimeout(Duration.ofSeconds(10)) // 연결 타임아웃 10초로 설정
                .setReadTimeout(Duration.ofSeconds(10)) // 읽기 타임아웃 10초로 설정
                .build();
    }


    @Bean
    public Gson gson() {
        return new Gson();
    }


}
