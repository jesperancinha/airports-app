package org.jesperancinha.airports

import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner
import org.apache.camel.test.spring.CamelTestContextBootstrapper
import org.jesperancinha.airports.services.ReportAirportService
import org.junit.Ignore
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
@ContextConfiguration(
    loader = CamelSpringDelegatingTestContextLoader::class
)
@DirtiesContext
@Ignore
class ReportAirportServiceTest(
    @Autowired
    val reportAirportService: ReportAirportService

) {

    @get:Test
    val countriesWithHighestNumberOfAirports: Unit
        get() {
            val topTen: Map<String, Long> = reportAirportService.getCountriesWithHighestNumberOfAirports(10)
        }

    @get:Test
    val countriesWithLowesNumberOfAirports: Unit
        get() {}

    @get:Test
    val runwaysMostCommonlyIdentified: Unit
        get() {}
}