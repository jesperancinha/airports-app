package org.jesperancinha.service.services;

import com.jesperancinha.service.containers.MainContainerService;
import com.jesperancinha.service.pojos.Airport;
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
public class QueryAirportServiceImpl implements QueryAirportService {

    @BeanInject
    MainContainerService mainContainerService;

    @Override
    public List<Airport> getAirportsByCountryName(String countryName) {
        return mainContainerService.getFullAiportInfo()
                .stream()
                .filter(airport -> airport.getCountry() != null && countryName.toLowerCase().equals(airport.getCountry().getName().toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Airport> getAirportsByCountryCode(String countryCode) {
        return mainContainerService.getFullAiportInfo()
                .stream()
                .filter(airport -> countryCode.toLowerCase().equals(airport.getIsoCountry().toLowerCase()))
                .collect(Collectors.toList());
    }
}
