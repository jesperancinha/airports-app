package org.jesperancinha.airports.containers;

import lombok.Getter;
import lombok.Setter;
import org.jesperancinha.airports.pojos.Airport;
import org.jesperancinha.airports.pojos.Country;
import org.jesperancinha.airports.pojos.Runway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
@Getter
@Setter
@Service
public class MainContainerService {

    private AirportContainer airportContainer = new AirportContainer();

    private CountryContainer countryContainer = new CountryContainer();

    private RunwayContainer runwayContainer = new RunwayContainer();

    private List<Airport> fullAiportInfo;

    public MainContainerService() throws IOException {
        List<Airport> airports = airportContainer.getAirports();
        List<Country> countries = countryContainer.getCountries();
        List<Runway> runways = runwayContainer.getRunways();

        airports.sort(Comparator.comparing(Airport::getIsoCountry));
        countries.sort(Comparator.comparing(Country::getCode));

        fullAiportInfo = airports
                .parallelStream()
                .peek(airport -> airport
                        .setCountry(countries.stream()
                                .filter(country -> country.getCode().equals(airport.getIsoCountry()))
                                .findFirst()
                                .orElse(null)))
                .collect(Collectors.toList());

        fullAiportInfo = airports
                .parallelStream()
                .peek(airport -> airport
                        .addRunWay(runways.stream()
                                .filter(runway -> runway.getAirportIdent().equals(airport.getIdent()))
                                .findFirst()
                                .orElse(null)))
                .collect(Collectors.toList());
    }
}
