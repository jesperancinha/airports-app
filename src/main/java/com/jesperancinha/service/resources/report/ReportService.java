package com.jesperancinha.service.resources.report;

import java.io.IOException;

/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
public class ReportService {

    public ReportProvider getReportProvider() throws IOException {
        return ReportProvider.builder().name("getReportProvider").build();
    }
}
