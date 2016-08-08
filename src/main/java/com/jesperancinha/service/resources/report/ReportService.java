package com.jesperancinha.service.resources.report;

import org.apache.camel.impl.SimpleRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
@Component
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

    @Autowired
    SimpleRegistry registry;

    @PostConstruct
    public void init()
    {
        registry.put("reportService", this);
    }
}
