package com.example.ga4.restTemplate.spring5;

import com.example.ga4.restTemplate.spring5.domain.GoogleAnalysticsVO;

public interface GoogleAnalysticsService {
    GoogleAnalysticsVO getVisitorCache(GoogleAnalysticsVO gaVo, String accessToken);
}
