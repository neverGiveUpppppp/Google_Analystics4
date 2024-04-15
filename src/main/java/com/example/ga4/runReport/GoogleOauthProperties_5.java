package com.example.ga4.runReport;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "google.oauth")
@Getter
@Setter
public class GoogleOauthProperties_5 {

    private String accessToken;
    private String analyticsUrl;
    private String clientId;
    private String clientSecret;

    private String refreshTokenUrl;
    private String refreshToken;

    private String redirectUri;



}
