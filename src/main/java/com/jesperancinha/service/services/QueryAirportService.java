package com.jesperancinha.service.services;

import com.jesperancinha.service.pojos.Airport;

import java.util.List;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
public interface QueryAirportService {

    List<Airport> getAirportsByCountryName(String countryName);

    List<Airport> getAirportsByCountryCode(String countryCode);
}
