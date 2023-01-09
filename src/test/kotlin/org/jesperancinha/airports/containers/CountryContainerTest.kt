package org.jesperancinha.airports.containers

import org.hamcrest.Matchers
import org.jesperancinha.airports.pojos.Country
import org.junit.Assert
import org.junit.Test

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
class CountryContainerTest {
    @Test
    fun `should run country test container`(){
            val airportContainer = CountryContainer()
            val countries: List<Country> = airportContainer.countries
            val country = countries[0]
            Assert.assertThat(countries, Matchers.hasSize(248))
            Assert.assertThat(country.id, Matchers.notNullValue())
        }
}