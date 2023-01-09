package org.jesperancinha.airports

import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner
import org.apache.camel.test.spring.CamelTestContextBootstrapper
import org.jesperancinha.airports.pojos.Airport
import org.jesperancinha.airports.services.QueryAirportService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.BootstrapWith
import org.springframework.test.context.ContextConfiguration

@RunWith(CamelSpringJUnit4ClassRunner::class)
@BootstrapWith(CamelTestContextBootstrapper::class)
@ContextConfiguration(
    loader = CamelSpringDelegatingTestContextLoader::class
)
@DirtiesContext
class QueryAirportServiceIT(
    @Autowired
    val queryAirportService: QueryAirportService
) {

    @get:Throws(Exception::class)
    @get:Test
    val airportsByCountryName: Unit
        get() {
            val airports: List<Airport> = queryAirportService.getAirportsByCountryName("Portugal")
            Assert.assertNotNull(queryAirportService)
            Assert.assertNotNull(airports)
        }

    @get:Throws(Exception::class)
    @get:Test
    val airportsByCountryCode: Unit
        get() {}
}