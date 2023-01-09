package org.jesperancinha.airports.containers

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import org.apache.camel.test.spring.junit5.CamelSpringBootTest
import org.jesperancinha.airports.pojos.Airport
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
class MainContainerIT @Autowired constructor(
    val mainContainerService: MainContainerService
) {

    @Test
    fun `should run main test container`() {
        val airports: List<Airport> = mainContainerService.fullAiportInfo
        val airport = airports[0]

        airports.shouldHaveSize(46506)
        airport.shouldNotBeNull()
        airport.id.shouldNotBeNull()
        airport.country.shouldNotBeNull()
    }
}