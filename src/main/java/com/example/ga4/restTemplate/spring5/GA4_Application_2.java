package com.example.ga4.restTemplate.spring5;

import com.example.ga4.runReport_serviceAccount.GA4RunReportProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GA4RunReportProperties.class)
public class GA4_Application_2 {

    public static void main(String[] args) {
        SpringApplication.run(GA4_Application_2.class, args);
    }

}
