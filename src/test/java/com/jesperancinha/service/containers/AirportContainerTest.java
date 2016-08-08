package com.jesperancinha.service.containers;

import com.jesperancinha.service.pojos.Airport;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
public class AirportContainerTest {
    @Test
    public void getAirports() throws Exception {
        final AirportContainer airportContainer = new AirportContainer();

        List<Airport> airports = airportContainer.getAirports();
        Airport airport = airports.get(0);

        assertThat(airports, hasSize(46506));
        assertThat(airport.getId(), notNullValue());
    }
}