package org.jesperancinha.airports.services

import org.apache.camel.BeanInject
import org.springframework.context.annotation.DependsOn
import org.springframework.stereotype.Service
import java.io.IOException

/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
@Service
@DependsOn(value = ["queryAirportService"])
class QueryService(
    @BeanInject
    val queryAirportService: QueryAirportService
) {

    @Throws(IOException::class)
    fun getQueryProviderByCountryName(countryName: String): QueryProvider {
        return QueryProvider(
            airportList = queryAirportService.getAirportsByCountryName(countryName)
        )
    }

    @Throws(IOException::class)
    fun getQueryProviderByCountryCode(countryCode: String): QueryProvider {
        return QueryProvider(
            airportList = queryAirportService.getAirportsByCountryCode(countryCode)
        )
    }
}