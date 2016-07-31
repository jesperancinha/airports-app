package com.jesperancinha.service.services;

import com.jesperancinha.service.pojos.Country;
import com.jesperancinha.service.pojos.Runway;

import java.util.List;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
public interface ReportService {

    List<Country> getCountriesWithHighestNumberOfAirports(int listSize);

    List<Country> getCountriesWithLowesNumberOfAirports(int listSize);

    List<Runway> getRunwaysMostCommonlyIdentified(int listSize);
}
