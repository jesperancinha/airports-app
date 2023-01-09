package org.jesperancinha.airports.services

import org.apache.camel.BeanInject
import org.jesperancinha.airports.containers.MainContainerService
import org.jesperancinha.airports.pojos.Airport
import org.springframework.stereotype.Service

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Service
class QueryAirportService(
    @BeanInject
    val mainContainerService: MainContainerService
) {

    fun getAirportsByCountryName(countryName: String): List<Airport> {
        return mainContainerService.fullAiportInfo
            .filter { airport: Airport ->
                airport.country != null && countryName.equals(
                    airport.country?.name,
                    ignoreCase = true
                )
            }
    }

    fun getAirportsByCountryCode(countryCode: String): List<Airport> {
        return mainContainerService.fullAiportInfo
            .filter { airport: Airport -> countryCode.equals(airport.isoCountry, ignoreCase = true) }
    }
}