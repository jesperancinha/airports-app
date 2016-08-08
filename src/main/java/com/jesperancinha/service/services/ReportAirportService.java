package com.jesperancinha.service.services;

import com.jesperancinha.service.pojos.Runway;

import java.util.List;
import java.util.Map;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
public interface ReportAirportService {

    Map<String, Long> getCountriesWithHighestNumberOfAirports(int listSize);

    Map<String, Long> getCountriesWithLowesNumberOfAirports(int listSize);

    List<Runway> getRunwaysMostCommonlyIdentified(int listSize);
}
