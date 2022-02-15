package com.jesperancinha.service.resources.query;

import org.jesperancinha.service.services.QueryAirportService;
import org.apache.camel.BeanInject;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
@Component
@DependsOn(value = "queryAirportService")
public class QueryService {

    @BeanInject
    QueryAirportService queryAirportService;

    public QueryProvider getQueryProviderByCountryName(String countryName) throws IOException {
        return QueryProvider
                .builder()
                .airportList(queryAirportService.getAirportsByCountryName(countryName))
                .build();
    }

    public QueryProvider getQueryProviderByCountryCode(String countryCode) throws IOException {
        return QueryProvider
                .builder()
                .airportList(queryAirportService.getAirportsByCountryCode(countryCode))
                .build();
    }
}
