package com.example.ga4.restTemplate.spring5;

import com.example.ga4.restTemplate.spring5.config.GoogleOauth2Properties;
import com.example.ga4.restTemplate.spring5.domain.GoogleAnalysticsVO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GoogleAnalysticsController2")
@RequestMapping("/user/ga4OAuth2/2")
public class GoogleAnalysticsController {

    private GoogleAnalysticsService gaService;
    private final GoogleOauth2Properties oauthProps;

    public GoogleAnalysticsController(GoogleAnalysticsService gaService, GoogleOauth2Properties oauthProps) {
        this.gaService = gaService;
        this.oauthProps = oauthProps;
    }

    @RequestMapping("/ND_ga4Visitor.do")
    public String /*String*/ makeAnalyticsRequest(GoogleAnalysticsVO gaVo, Model model) {
        GoogleAnalysticsVO response = gaService.getVisitorCache(gaVo, oauthProps.getAccessToken());
        model.addAttribute("ga4Vo", response);
        return "visitorsShow";
    }

}
