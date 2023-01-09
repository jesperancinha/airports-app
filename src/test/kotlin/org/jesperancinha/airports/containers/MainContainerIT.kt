package org.jesperancinha.airports.containers

import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner
import org.apache.camel.test.spring.CamelTestContextBootstrapper
import org.hamcrest.Matchers
import org.jesperancinha.airports.pojos.Airport
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.BootstrapWith
import org.springframework.test.context.ContextConfiguration

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
@RunWith(CamelSpringJUnit4ClassRunner::class)
@BootstrapWith(CamelTestContextBootstrapper::class)
@ContextConfiguration(classes = [MainContainerService::class], loader = CamelSpringDelegatingTestContextLoader::class)
@DirtiesContext
class MainContainerIT @Autowired constructor(
    val mainContainerService: MainContainerService
) {

    @Test
    fun `should run main test container`() {
        val airports: List<Airport> = mainContainerService.fullAiportInfo
        val airport = airports[0]
        Assert.assertThat(airports, Matchers.hasSize(46506))
        Assert.assertThat(airport.id, Matchers.notNullValue())
        Assert.assertThat(airport.country, Matchers.notNullValue())
    } //    @Configuration
    //    public static class ContextConfig extends SingleRouteCamelConfiguration {
    //
    //        @Bean(ref = "")
    //        @Override
    //        public RouteBuilder route() {
    //            return new QueryRestRouteBuilder();
    //        }
    //    }
}