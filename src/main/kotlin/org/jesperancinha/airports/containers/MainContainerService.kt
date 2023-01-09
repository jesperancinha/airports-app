package org.jesperancinha.airports.containers

import org.jesperancinha.airports.pojos.Airport
import org.jesperancinha.airports.pojos.Country
import org.jesperancinha.airports.pojos.Runway
import org.springframework.stereotype.Service
import java.util.stream.Collectors

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
@Service
class MainContainerService(
    var fullAiportInfo: List<Airport>
){
    private val airportContainer: AirportContainer = AirportContainer()
    private val countryContainer: CountryContainer = CountryContainer()
    private val runwayContainer: RunwayContainer = RunwayContainer()
    init {
        val airports = airportContainer.airports
        val countries = countryContainer.countries
        val runways = runwayContainer.runways
        fullAiportInfo = getFullAirportInfo(airports, countries, runways)

    }

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