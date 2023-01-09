package org.jesperancinha.airports.containers;

import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.CamelTestContextBootstrapper;
import org.jesperancinha.airports.pojos.Airport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
        MainContainerService.class
},
        loader = CamelSpringDelegatingTestContextLoader.class)
@DirtiesContext
public class MainContainerIT {

    @Autowired
    MainContainerService mainContainerService;

    @Test
    public void getFullAiportInfo() {

        List<Airport> airports = mainContainerService.getFullAiportInfo();
        Airport airport = airports.get(0);

        assertThat(airports, hasSize(46506));
        assertThat(airport.getId(), notNullValue());
        assertThat(airport.getCountry(), notNullValue());
    }

//    @Configuration
//    public static class ContextConfig extends SingleRouteCamelConfiguration {
//
//        @Bean(ref = "")
//        @Override
//        public RouteBuilder route() {
//            return new QueryRestRouteBuilder();
//        }
//    }
}