package com.jesperancinha.service.services;

import com.jesperancinha.service.containers.MainContainerService;
import com.jesperancinha.service.pojos.Airport;
import org.apache.camel.BeanInject;
import org.apache.camel.impl.SimpleRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */

@Component
@Service(value = "queryAirportService")
public class QueryAirportServiceImpl implements QueryAirportService {

    @Autowired
    MainContainerService mainContainerServiceFromSpring;

    @BeanInject
    MainContainerService mainContainerServiceFromCamel;

    @Autowired
    SimpleRegistry registry;

    @Autowired
    @PostConstruct
    public void init() {
        registry.put("mainContainerService", mainContainerServiceFromSpring);
        registry.put("queryAirportService", this);
    }

    @Override
    public List<Airport> getAirportsByCountryName(String countryName) {
        return mainContainerServiceFromCamel.getFullAiportInfo()
                .stream()
                .filter(airport -> airport.getCountry() != null && countryName.toLowerCase().equals(airport.getCountry().getName().toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Airport> getAirportsByCountryCode(String countryCode) {
        return mainContainerServiceFromCamel.getFullAiportInfo()
                .stream()
                .filter(airport -> countryCode.toLowerCase().equals(airport.getIsoCountry().toLowerCase()))
                .collect(Collectors.toList());
    }
}
