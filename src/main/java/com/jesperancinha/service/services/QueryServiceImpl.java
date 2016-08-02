package com.jesperancinha.service.services;

import com.jesperancinha.service.pojos.Airport;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Component
public class QueryServiceImpl implements QueryService {

    @Override
    public List<Airport> getAirportsByCountryName(String countryName) {
        return null;
    }

    @Override
    public List<Airport> getAirportsByCountryCode(String countryCode) {
        return null;
    }
}
