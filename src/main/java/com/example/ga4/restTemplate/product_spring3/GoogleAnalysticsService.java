package com.example.ga4.restTemplate.product_spring3;

import com.example.ga4.restTemplate.product_spring3.domain.GoogleAnalysticsVO;

public interface GoogleAnalysticsService {
    GoogleAnalysticsVO getVisitorCache(GoogleAnalysticsVO gaVo, String accessToken);
}
