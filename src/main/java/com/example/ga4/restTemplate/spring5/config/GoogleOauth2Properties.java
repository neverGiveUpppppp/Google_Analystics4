package com.example.ga4.restTemplate.spring5.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("GoogleOauth2Properties2")
@Getter
@Setter
public class GoogleOauth2Properties {

    @Value("${google.oauth.accessToken")
    private String accessToken;

    @Value("${google.oauth.analyticsUrl")
    private String analyticsUrl;

    @Value("${google.oauth.clientId")
    private String clientId;

    @Value("${google.oauth.clientSecret")
    private String clientSecret;

    @Value("${google.oauth.refreshTokenUrl")
    private String refreshTokenUrl;

    @Value("${google.oauth.refreshToken")
    private String refreshToken;

    @Value("${google.oauth.redirectUri")
    private String redirectUri;



}
