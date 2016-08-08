package com.jesperancinha.service.configuration;

import com.jesperancinha.service.resources.query.QueryRestRouteBuilder;
import com.jesperancinha.service.resources.report.ReportRestRouteBuilder;
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
@ComponentScan(basePackages = {
        "com.jesperancinha.service",
        "com.jesperancinha.service.services"
})

public class AirportsAppConfiguration {
    private static SimpleRegistry registry = new SimpleRegistry();

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
        return camelContext;
    }

}
