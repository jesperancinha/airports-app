package com.jesperancinha.service.services;

import com.jesperancinha.service.configuration.AirportsAppConfiguration;
import com.jesperancinha.service.pojos.Airport;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.CamelTestContextBootstrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@BootstrapWith(CamelTestContextBootstrapper.class)
@ContextConfiguration(classes = {
        AirportsAppConfiguration.class
},
        loader = CamelSpringDelegatingTestContextLoader.class)
@DirtiesContext
public class QueryAirportServiceIT {

    @Autowired
    QueryAirportService queryAirportService;

    @Test
    public void getAirportsByCountryName() throws Exception {
        List<Airport> airports = queryAirportService.getAirportsByCountryName("Portugal");
        assertNotNull(queryAirportService);
        assertNotNull(airports);
    }

    @Test
    public void getAirportsByCountryCode() throws Exception {

    }

}