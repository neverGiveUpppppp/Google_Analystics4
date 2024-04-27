package com.example.ga4.restTemplate.product_spring3.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration("GoogleAnalysticsConfig1")
public class GoogleAnalysticsConfig {

    @Bean("restTemplate1")
    public RestTemplate restTemplate(){
        return new RestTemplate(clientHttpRequestFactory());
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() { // ClientHttpRequestFactory : spring3
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(10*1000); // 10초 설정 : milliseconds단위
//        factory.setReadTimeout(10*1000);
        return factory;
    }

    @Bean("gson1")
    public Gson gson() {
        return new Gson();
    }


}
