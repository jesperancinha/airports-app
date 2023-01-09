package org.jesperancinha.airports.containers;

import org.jesperancinha.airports.configuration.AirportsAppConfiguration;
import org.jesperancinha.airports.pojos.Airport;
import org.jesperancinha.airports.resources.query.QueryRestRouteBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.language.bean.Bean;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.CamelTestContextBootstrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
@RunWith(CamelSpringJUnit4ClassRunner.class)
@BootstrapWith(CamelTestContextBootstrapper.class)
@ContextConfiguration(classes = {
        AirportsAppConfiguration.class,
        MainContainerServiceImpl.class
},
        loader = CamelSpringDelegatingTestContextLoader.class)
@DirtiesContext
public class MainContainerIT {

    @Autowired
    MainContainerServiceImpl mainContainerService;

    @Test
    public void getFullAiportInfo() {

        List<Airport> airports = mainContainerService.getFullAiportInfo();
        Airport airport = airports.get(0);

        assertThat(airports, hasSize(46506));
        assertThat(airport.getId(), notNullValue());
        assertThat(airport.getCountry(), notNullValue());
    }

    @Configuration
    public static class ContextConfig extends SingleRouteCamelConfiguration {

        @Bean(ref = "")
        @Override
        public RouteBuilder route() {
            return new QueryRestRouteBuilder();
        }
    }
}