package com.jesperancinha.service.services;

import com.jesperancinha.service.pojos.Country;
import com.jesperancinha.service.pojos.Runway;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Component
public class ReportServiceImpl implements ReportService {

    @Override
    public List<Country> getCountriesWithHighestNumberOfAirports(int listSize) {
        return null;
    }

    @Override
    public List<Country> getCountriesWithLowesNumberOfAirports(int listSize) {
        return null;
    }

    @Override
    public List<Runway> getRunwaysMostCommonlyIdentified(int listSize) {
        return null;
    }
}
