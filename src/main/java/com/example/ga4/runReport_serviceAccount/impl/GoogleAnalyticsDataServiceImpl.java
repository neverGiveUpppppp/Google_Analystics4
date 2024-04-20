package com.example.ga4.runReport_serviceAccount.impl;

import com.example.ga4.runReport_serviceAccount.AnalyticsData;
import com.example.ga4.runReport_serviceAccount.GA4RunReportProperties;
import com.example.ga4.runReport_serviceAccount.GoogleAnalyticsDataService;
import com.google.analytics.data.v1beta.*;
import lombok.RequiredArgsConstructor;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("GoogleAnalysticsServiceImpl3")
@RequiredArgsConstructor
public class GoogleAnalyticsDataServiceImpl implements GoogleAnalyticsDataService {

    private final AnalyticsData analyticsData;
    @Qualifier("ehCacheManager3")
    private final CacheManager cacheManager;
    @Qualifier("GA4RunReportProperties")
    private final GA4RunReportProperties probs;

    @Override
    public String ga4CacheToday() {
        Cache<String, String> cache = cacheManager.getCache("visitorCounts", String.class, String.class);

        String todayNum = "todayNum";          // 캐쉬데이터 키값 초기화
        String todayCnt = cache.get(todayNum); // 캐쉬값 로드
        if (todayCnt == null || todayCnt.isEmpty()) {
            String today = getVisitors(probs.getPropertyId(), "today", "today", true); // GA4에서 방문자 수 가져오기
            // 캐시에 저장
            cache.put(todayNum, today);
            todayCnt = cache.get(todayNum);
        }
        return todayCnt;
    }

    @Override
    public String ga4CacheAll() {
        Cache<String, String> cache = cacheManager.getCache("visitorCounts", String.class, String.class);

        // 전체 방문자 수 조회
        String allNum = "allNum";          // 캐쉬데이터 키값 초기화
        String allCnt = cache.get(allNum); // 캐쉬값 로드

        if (allCnt == null || allCnt.isEmpty()) {
            String all = getVisitors(probs.getPropertyId(), "2024-01-28", "today", false);
            // 캐시에 저장
            cache.put(allNum, all);
            allCnt = cache.get(allNum);
        }
        return allCnt;
    }

    private String getVisitors(String propertyId, String startDate, String endDate, boolean retryOnFailure) {
        try {
            return tryRunReport(propertyId, startDate, endDate);
        } catch (Exception e) {
            if (retryOnFailure) {
                // 실패 시 재시도 로직
                try {
                    return tryRunReport(propertyId, "yesterday", endDate);
                } catch (Exception retryException) {
                    retryException.printStackTrace();
                }
            } else {
                e.printStackTrace();
            }
        }
        return "0"; // 실패 시 기본값 반환
    }

    private String tryRunReport(String propertyId, String startDate, String endDate) throws Exception {
        RunReportRequest request = RunReportRequest.newBuilder()
                .setProperty("properties/" + propertyId)
                .addDimensions(Dimension.newBuilder().setName("city"))
                .addMetrics(Metric.newBuilder().setName("totalUsers"))
                .addDateRanges(DateRange.newBuilder().setStartDate(startDate).setEndDate(endDate))
                .build();
        RunReportResponse response = analyticsData.runReport(request);
        return response.getRows(0).getMetricValues(0).getValue();
    }

}
