package org.jesperancinha.airports.containers

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import org.jesperancinha.airports.pojos.Runway
import org.junit.Test

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
class RunwayContainerTest {
    @Test
    fun `should run runway test container`() {
        val runwayContainer = RunwayContainer()
        val runways: List<Runway> = runwayContainer.runways
        val runway = runways[0]
        runways.shouldHaveSize(39537)
        runway.shouldNotBeNull()
        runway.id.shouldNotBeNull()
    }
}