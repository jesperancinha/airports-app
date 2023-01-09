package org.jesperancinha.airports.services;

import org.jesperancinha.airports.containers.MainContainerServiceImpl;
import org.jesperancinha.airports.pojos.Airport;
import org.apache.camel.BeanInject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */

@Component
@Service(value = "queryAirportService")
public class QueryAirportService {

    @BeanInject
    MainContainerServiceImpl mainContainerService;

    public List<Airport> getAirportsByCountryName(String countryName) {
        return mainContainerService.getFullAiportInfo()
                .stream()
                .filter(airport -> airport.getCountry() != null && countryName.toLowerCase().equals(airport.getCountry().getName().toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Airport> getAirportsByCountryCode(String countryCode) {
        return mainContainerService.getFullAiportInfo()
                .stream()
                .filter(airport -> countryCode.toLowerCase().equals(airport.getIsoCountry().toLowerCase()))
                .collect(Collectors.toList());
    }
}
