package com.jesperancinha.service.resources.report;

import java.io.IOException;

/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
public class ReportService {

    public ReportProvider getMostReportProvider() throws IOException {
        return ReportProvider.builder().name("getMostReportProvider").build();
    }

    public ReportProvider getLeastReportProvider() throws IOException {
        return ReportProvider.builder().name("getLeastReportProvider").build();
    }

    public ReportProvider getMostRunwayProvider() throws IOException {
        return ReportProvider.builder().name("getMostRunwayProvider").build();
    }
}
