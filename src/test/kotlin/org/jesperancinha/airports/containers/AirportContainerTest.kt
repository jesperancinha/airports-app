package org.jesperancinha.airports.containers

import org.hamcrest.Matchers
import org.jesperancinha.airports.pojos.Airport
import org.junit.Assert
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
        Assert.assertThat(airports, Matchers.hasSize(46506))
        Assert.assertThat(airport.id, Matchers.notNullValue())
    }
}