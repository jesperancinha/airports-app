package org.jesperancinha.airports.services

import org.apache.camel.BeanInject
import org.jesperancinha.airports.containers.MainContainerService
import org.jesperancinha.airports.pojos.Runway
import org.springframework.stereotype.Service

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Service
class ReportAirportService(
    @BeanInject
    val mainContainerService: MainContainerService
) {

    fun getCountriesWithHighestNumberOfAirports(listSize: Int): Map<String, Long> {
        val listOfAirports = mainContainerService.fullAiportInfo
        return listOfAirports
            .sortedBy { it.isoCountry }
            .groupingBy { it.isoCountry }
            .eachCount()
            .entries
            .sortedBy { it.value }
            .reversed()
            .take(listSize)
            .associate { it.key to it.value.toLong() }

    }

    fun getCountriesWithLowesNumberOfAirports(listSize: Int): Map<String, Long> {
        val listOfAirports = mainContainerService.fullAiportInfo
        return listOfAirports
            .sortedBy { it.isoCountry }
            .groupingBy { it.isoCountry }
            .eachCount()
            .entries
            .sortedBy { it.value }
            .take(listSize)
            .associate { it.key to it.value.toLong() }
    }

    fun getRunwaysMostCommonlyIdentified(listSize: Int): List<Runway>? {
        return null
    }
}