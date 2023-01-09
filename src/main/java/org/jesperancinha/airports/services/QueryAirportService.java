package org.jesperancinha.airports.services;

import org.apache.camel.BeanInject;
import org.jesperancinha.airports.containers.MainContainerService;
import org.jesperancinha.airports.pojos.Airport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Service
public class QueryAirportService {

    @BeanInject
    MainContainerService mainContainerService;

    public List<Airport> getAirportsByCountryName(String countryName) {
        return mainContainerService.getFullAiportInfo()
                .stream()
                .filter(airport -> airport.getCountry() != null && countryName.equalsIgnoreCase(airport.getCountry().getName()))
                .collect(Collectors.toList());
    }

    public List<Airport> getAirportsByCountryCode(String countryCode) {
        return mainContainerService.getFullAiportInfo()
                .stream()
                .filter(airport -> countryCode.equalsIgnoreCase(airport.getIsoCountry()))
                .collect(Collectors.toList());
    }
}
