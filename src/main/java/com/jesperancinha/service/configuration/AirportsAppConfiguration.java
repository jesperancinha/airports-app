package com.jesperancinha.service.configuration;

import com.jesperancinha.service.containers.MainContainerService;
import com.jesperancinha.service.resources.query.QueryRestRouteBuilder;
import com.jesperancinha.service.resources.report.ReportRestRouteBuilder;
import com.jesperancinha.service.services.QueryAirportService;
import com.jesperancinha.service.services.ReportAirportService;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.jesperancinha.service.configuration",
        "com.jesperancinha.service.containers",
        "com.jesperancinha.service.services",
        "com.jesperancinha.service.resources"
})
public class AirportsAppConfiguration {
    private static SimpleRegistry registry = new SimpleRegistry();

    @Autowired
    MainContainerService mainContainerService;

    @Autowired
    ReportAirportService reportAirportService;

    @Autowired
    QueryAirportService queryAirportService;

    @Bean
    SimpleRegistry registry() {
        return registry;
    }

    @Bean
    CamelContext camelContext() throws Exception {
        CamelContext camelContext = new DefaultCamelContext(registry);
        camelContext.addRoutes(new QueryRestRouteBuilder());
        camelContext.addRoutes(new ReportRestRouteBuilder());
        camelContext.start();
        registry.put("mainContainerService", mainContainerService);
        return camelContext;
    }

    @PostConstruct
    public void init() {
        registry.put("reportAirportService", reportAirportService);
        registry.put("queryAirportService", queryAirportService);
    }

}
