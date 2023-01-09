package org.jesperancinha.airports.services

import org.apache.camel.BeanInject
import org.springframework.context.annotation.DependsOn
import org.springframework.stereotype.Component
import java.io.IOException

/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
@Component
@DependsOn("reportAirportService")
class ReportService(
    @BeanInject
    val reportAirportService: ReportAirportService
) {

    @get:Throws(IOException::class)
    val mostReportProvider: ReportProvider
        get() = ReportProvider(
            listOfResults = reportAirportService.getCountriesWithHighestNumberOfAirports(10)
        )

    @get:Throws(IOException::class)
    val leastReportProvider: ReportProvider
        get() = ReportProvider(
            listOfResults = reportAirportService.getCountriesWithLowesNumberOfAirports(10)
        )

    @get:Throws(IOException::class)
    val mostRunwayProvider: ReportProvider?
        get() = null
}