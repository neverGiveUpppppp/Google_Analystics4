package com.example.ga4.runReport_serviceAccount;

import com.example.ga4.runReport_serviceAccount.domain.GoogleAnalytics4Vo;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// service account 인증 방식
@RestController("GoogleAnalysticsController3")
@RequiredArgsConstructor
public class GoogleAnalyticsDataController {

    private final GoogleAnalyticsDataService service;

    @RequestMapping(value = "/ND_ga4Visitor.do")
    public void ga4DataAjaxCall(GoogleAnalytics4Vo ga4Vo, Model model) {
        ga4Vo.setTodayVisitors(service.ga4CacheToday());
        ga4Vo.setAllVisitors(service.ga4CacheAll());
        model.addAttribute("ga4Vo", ga4Vo);
    }

}
