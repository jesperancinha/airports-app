package org.jesperancinha.airports.containers;

import org.jesperancinha.airports.pojos.Airport;
import org.jesperancinha.airports.pojos.Country;
import org.jesperancinha.airports.pojos.Runway;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
@Getter
@Setter
@Component
@Service(value = "mainContainerService")
public class MainContainerServiceImpl {

    private AirportContainer airportContainer = new AirportContainer();

    private CountryContainer countryContainer = new CountryContainer();

    private RunwayContainer runwayContainer = new RunwayContainer();

    private List<Airport> fullAiportInfo;

    public MainContainerServiceImpl() throws IOException {
        List<Airport> airports = airportContainer.getAirports();
        List<Country> countries = countryContainer.getCountries();
        List<Runway> runways = runwayContainer.getRunways();

        airports.sort((o1, o2) -> o1.getIsoCountry().compareTo(o2.getIsoCountry()));
        countries.sort((o1, o2) -> o1.getCode().compareTo(o2.getCode()));

        fullAiportInfo = airports
                .parallelStream()
                .map(airport -> {
                    airport
                            .setCountry(countries.stream()
                                    .filter(country -> country.getCode().equals(airport.getIsoCountry()))
                                    .findFirst()
                                    .orElse(null));
                    return airport;
                })
                .collect(Collectors.toList());

        fullAiportInfo = airports
                .parallelStream()
                .map(airport -> {
                    airport
                            .addRunWay(runways.stream()
                                    .filter(runway -> runway.getAirportIdent().equals(airport.getIdent()))
                                    .findFirst()
                                    .orElse(null));
                    return airport;
                })
                .collect(Collectors.toList());
    }
}
