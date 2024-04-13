package com.example.ga4.restTemplate.product_spring3;

import com.example.ga4.runReport.GoogleOauthProperties_5;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GoogleOauthProperties_5.class)
public class GA4_Spring3_Product_Application {

    public static void main(String[] args) {
        SpringApplication.run(GA4_Spring3_Product_Application.class, args);
    }

}
