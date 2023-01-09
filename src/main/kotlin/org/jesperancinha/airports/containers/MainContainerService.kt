package org.jesperancinha.airports.containers

import org.jesperancinha.airports.pojos.Airport
import org.jesperancinha.airports.pojos.Country
import org.jesperancinha.airports.pojos.Runway
import org.springframework.stereotype.Service

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
@Service
class MainContainerService(
) {
    private val airportContainer: AirportContainer by lazy { AirportContainer() }
    private val countryContainer: CountryContainer by lazy { CountryContainer() }
    private val runwayContainer: RunwayContainer by lazy { RunwayContainer() }
    private val airports = airportContainer.airports
    private val countries = countryContainer.countries
    private val runways = runwayContainer.runways
    val fullAiportInfo by lazy { getFullAirportInfo(airports, countries, runways) }


    private fun getFullAirportInfo(
        airports: List<Airport>,
        countries: List<Country>,
        runways: List<Runway>
    ) = airports
        .sortedBy { it.isoCountry }
        .map { airport: Airport ->
            airport.country = countries
                .sortedBy { it.code }
                .stream()
                .filter { country -> country.code == airport.isoCountry }
                .findFirst()
                .orElse(null)
            airport
        }
        .map { airport: Airport ->
            val extraRunway = runways.firstOrNull { runway -> runway.airportIdent == airport.ident }
            extraRunway?.let {
                airport
                    .addRunWay(extraRunway)
            }
            airport
        }
}