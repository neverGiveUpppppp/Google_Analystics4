package com.example.ga4.runReport_serviceAccount;

import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AnalyticsDataClient implements AnalyticsData{

    private final BetaAnalyticsDataClient client;

    public AnalyticsDataClient() throws IOException {
        this.client = BetaAnalyticsDataClient.create();
    }

    @Override
    public RunReportResponse runReport(RunReportRequest request) throws Exception {
        return client.runReport(request);
    }
}
