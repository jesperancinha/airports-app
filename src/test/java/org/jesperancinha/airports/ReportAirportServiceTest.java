package org.jesperancinha.airports;

import org.jesperancinha.airports.configuration.AirportsAppConfiguration;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.CamelTestContextBootstrapper;
import org.jesperancinha.airports.services.ReportAirportService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
@RunWith(CamelSpringJUnit4ClassRunner.class)
@BootstrapWith(CamelTestContextBootstrapper.class)
@ContextConfiguration(classes = {
        AirportsAppConfiguration.class
},
        loader = CamelSpringDelegatingTestContextLoader.class)
@DirtiesContext
@Ignore
public class ReportAirportServiceTest {

    @Autowired
    ReportAirportService reportAirportService;

    @Test
    public void getCountriesWithHighestNumberOfAirports() {
        Map<String, Long> topTen = reportAirportService.getCountriesWithHighestNumberOfAirports(10);
    }

    @Test
    public void getCountriesWithLowesNumberOfAirports() {

    }

    @Test
    public void getRunwaysMostCommonlyIdentified() {

    }

}