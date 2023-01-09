package org.jesperancinha.airports.containers

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import org.jesperancinha.airports.pojos.Airport
import org.junit.Test

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
class AirportContainerTest {
    @Test
    fun `should run airport test container`() {
        val airportContainer = AirportContainer()
        val airports: List<Airport> = airportContainer.airports
        val airport = airports[0]
        airports.shouldHaveSize(46506)
        airport.shouldNotBeNull()
        airport.id.shouldNotBeNull()
    }
}