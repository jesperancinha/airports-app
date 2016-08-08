package com.jesperancinha.service.resources.report;

import com.jesperancinha.service.services.ReportAirportService;
import org.apache.camel.BeanInject;
import org.apache.camel.impl.SimpleRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
@Component
@DependsOn("reportAirportService")
public class ReportService {

    @BeanInject
    ReportAirportService reportAirportService;

    public ReportProvider getMostReportProvider() throws IOException {

        return ReportProvider
                .builder()
                .listOfResults(reportAirportService.getCountriesWithHighestNumberOfAirports(10))
                .build();
    }

    public ReportProvider getLeastReportProvider() throws IOException {
        return  ReportProvider
                .builder()
                .listOfResults(reportAirportService.getCountriesWithLowesNumberOfAirports(10))
                .build();
    }

    public ReportProvider getMostRunwayProvider() throws IOException {
        return null;
    }

    @Autowired
    SimpleRegistry registry;

    @PostConstruct
    public void init() {
        registry.put("reportService", this);
    }
}
