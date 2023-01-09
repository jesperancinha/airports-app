package org.jesperancinha.airports.containers

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import org.jesperancinha.airports.pojos.Country
import java.io.InputStreamReader

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
class CountryContainer {
    private val mapper: CsvMapper by lazy { CsvMapper() }
    private val schema: CsvSchema by lazy {
        CsvSchema.builder()
            .setColumnSeparator(',')
            .addColumn("id")
            .addColumn("code")
            .addColumn("name")
            .addColumn("continent")
            .addColumn("wikipediaLink")
            .addColumn("keywords")
            .build()
    }
    val countries: List<Country> by lazy {
        val airportStream = javaClass.getResourceAsStream("/countries.csv")
        val it = mapper
            .reader(Country::class.java)
            .with(schema)
            .readValues<Country>(InputStreamReader(airportStream))
        it.readAll()
    }
}