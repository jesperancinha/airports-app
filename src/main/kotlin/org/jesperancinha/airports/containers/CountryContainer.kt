package org.jesperancinha.airports.containers

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import org.jesperancinha.airports.pojos.Country
import java.io.InputStreamReader

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
data class CountryContainer(
    val mapper: CsvMapper = CsvMapper(),
    val schema: CsvSchema? = CsvSchema.builder()
        .setColumnSeparator(',')
        .addColumn("id")
        .addColumn("code")
        .addColumn("name")
        .addColumn("continent")
        .addColumn("wikipediaLink")
        .addColumn("keywords")
        .build(),
    var countries: List<Country> = emptyList()
){
    init {
        countries = ArrayList()
        val airportStream = javaClass.getResourceAsStream("/countries.csv")
        val it = mapper
            .reader(Country::class.java)
            .with(schema)
            .readValues<Country>(InputStreamReader(airportStream))
        countries = it.readAll()
    }
}