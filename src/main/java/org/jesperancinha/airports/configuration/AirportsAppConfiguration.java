package org.jesperancinha.airports.configuration;

import org.jesperancinha.airports.containers.MainContainerServiceImpl;
import org.jesperancinha.airports.resources.query.QueryRestRouteBuilder;
import org.jesperancinha.airports.resources.report.ReportRestRouteBuilder;
import org.jesperancinha.airports.services.QueryAirportService;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.SimpleRegistry;
import org.jesperancinha.airports.services.ReportAirportService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
@Configuration
@ComponentScan(basePackages = {
        "org.jesperancinha.airports.configuration",
        "org.jesperancinha.airports.containers",
        "org.jesperancinha.airports",
        "org.jesperancinha.airports.resources"
})
public class AirportsAppConfiguration implements InitializingBean {
    private static SimpleRegistry registry = new SimpleRegistry();

    final
    MainContainerServiceImpl mainContainerService;

    final
    ReportAirportService reportAirportService;

    final
    QueryAirportService queryAirportService;

    public AirportsAppConfiguration(MainContainerServiceImpl mainContainerService, ReportAirportService reportAirportService, QueryAirportService queryAirportService) {
        this.mainContainerService = mainContainerService;
        this.reportAirportService = reportAirportService;
        this.queryAirportService = queryAirportService;
    }

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
        registry.put("mainContainerService", Map.of(mainContainerService.getClass(), mainContainerService));
        return camelContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        registry.put("reportAirportService", Map.of(reportAirportService.getClass(), reportAirportService));
        registry.put("queryAirportService", Map.of(queryAirportService.getClass(), queryAirportService));
    }
}
