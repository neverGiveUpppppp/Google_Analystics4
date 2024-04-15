package com.example.ga4.restTemplate.product_spring3;

import com.example.ga4.restTemplate.product_spring3.config.GoogleOauthProperties;
import com.example.ga4.restTemplate.product_spring3.domain.GoogleAnalysticsVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("GooglaAnalystics4")
@RequestMapping("/user/ga4OAuth2/1")
public class GoogleAnalysticsController /*extends UserController*/{

    private GoogleAnalysticsService gaService;
    private final GoogleOauthProperties oauthProps;

    public GoogleAnalysticsController(GoogleAnalysticsService gaService, GoogleOauthProperties oauthProps) {
        this.gaService = gaService;
        this.oauthProps = oauthProps;
    }

    @RequestMapping("/ND_ga4Visitor.do")
    public void /*String*/ makeAnalyticsRequest(GoogleAnalysticsVO gaVo, Model model) {
        GoogleAnalysticsVO response = gaService.getVisitorCache(gaVo, oauthProps.getAccessToken());
        model.addAttribute("ga4Vo", response);
        /*return responseJson(model, response);*/
    }

}
