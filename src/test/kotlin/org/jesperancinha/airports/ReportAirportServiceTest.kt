package org.jesperancinha.airports

import io.kotest.matchers.maps.shouldHaveSize
import org.apache.camel.test.spring.junit5.CamelSpringBootTest
import org.jesperancinha.airports.services.ReportAirportService
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
@CamelSpringBootTest
@EnableAutoConfiguration
@SpringBootTest
@DirtiesContext
@Disabled
class ReportAirportServiceTest(
    @Autowired
    val reportAirportService: ReportAirportService

) {

    @Test
    fun `should get countries with the highest number of airports`() {
        val topTen: Map<String, Long> = reportAirportService.getCountriesWithHighestNumberOfAirports(10)

        topTen.shouldHaveSize(10)
    }

    @Test
    fun `should get countries with the lowest number of airports`() {

    }

    @Test
    fun `should get runways most commmonly identifies`() {

    }
}