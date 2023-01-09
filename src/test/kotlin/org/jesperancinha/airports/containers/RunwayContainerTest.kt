package org.jesperancinha.airports.containers

import org.hamcrest.Matchers
import org.jesperancinha.airports.pojos.Runway
import org.junit.Assert
import org.junit.Test

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
class RunwayContainerTest {
    @get:Throws(Exception::class)
    @get:Test
    val runways: Unit
        get() {
            val runwayContainer = RunwayContainer()
            val runways: List<Runway> = runwayContainer.runways
            val runway = runways[0]
            Assert.assertThat(runways, Matchers.hasSize(39537))
            Assert.assertThat(runway.id, Matchers.notNullValue())
        }
}