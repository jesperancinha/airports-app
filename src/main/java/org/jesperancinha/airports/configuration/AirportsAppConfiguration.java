package org.jesperancinha.airports.configuration;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.RestConsumerFactory;
import org.apache.camel.support.SimpleRegistry;
import org.jesperancinha.airports.containers.MainContainerServiceImpl;
import org.jesperancinha.airports.resources.query.QueryRestRouteBuilder;
import org.jesperancinha.airports.resources.query.QueryService;
import org.jesperancinha.airports.resources.report.ReportRestRouteBuilder;
import org.jesperancinha.airports.resources.report.ReportService;
import org.jesperancinha.airports.services.QueryAirportService;
import org.jesperancinha.airports.services.ReportAirportService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
@Configuration
public class AirportsAppConfiguration implements InitializingBean {

    final
    MainContainerServiceImpl mainContainerService;

    final
    ReportAirportService reportAirportService;

    final
    QueryAirportService queryAirportService;
    final
    QueryService queryService;

    final ReportService reportService;

    public AirportsAppConfiguration(MainContainerServiceImpl mainContainerService, ReportAirportService reportAirportService, QueryAirportService queryAirportService, QueryService queryService, ReportService reportService) {
        this.mainContainerService = mainContainerService;
        this.reportAirportService = reportAirportService;
        this.queryAirportService = queryAirportService;
        this.queryService = queryService;
        this.reportService = reportService;
    }

    @Bean
    public CamelContext camelContext() throws Exception {
        SimpleRegistry registry = new SimpleRegistry();
        registry.put("mainContainerService", Map.of(mainContainerService.getClass(), mainContainerService));
        registry.put("reportAirportService", Map.of(reportAirportService.getClass(), reportAirportService));
        registry.put("queryAirportService", Map.of(queryAirportService.getClass(), queryAirportService));
        registry.put("queryService", Map.of(queryService.getClass(), queryService));
        registry.put("reportService", Map.of(reportService.getClass(), reportService));
        CamelContext camelContext = new DefaultCamelContext(registry);
        camelContext.addRoutes(new QueryRestRouteBuilder());
        camelContext.addRoutes(new ReportRestRouteBuilder());
        camelContext.start();
        return camelContext;
    }

    @Override
    public void afterPropertiesSet() {

    }
}
