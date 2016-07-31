package com.jesperancinha.service.configuration;

import com.jesperancinha.service.resources.query.QueryRestRouteBuilder;
import com.jesperancinha.service.resources.query.QueryService;
import com.jesperancinha.service.resources.report.ReportRestRouteBuilder;
import com.jesperancinha.service.resources.report.ReportService;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
@Configuration
@ComponentScan(basePackages ="com.jesperancinha.service" )
public class AirportsAppConfiguration {

    @Bean
    CamelContext camelContext() throws Exception {
        SimpleRegistry registry = new SimpleRegistry();
        registry.put("queryService", new QueryService());
        registry.put("reportService", new ReportService());
        CamelContext camelContext = new DefaultCamelContext(registry);
        camelContext.addRoutes(new QueryRestRouteBuilder());
        camelContext.addRoutes(new ReportRestRouteBuilder());
        camelContext.start();
        return camelContext;
    }

}
