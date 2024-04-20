package com.example.ga4.runReport_serviceAccount;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration("GA4RunReportProperties")
@ConfigurationProperties(prefix = "google.analystics")
@Getter
@Setter
public class GA4RunReportProperties {

    private String propertyId;




}
