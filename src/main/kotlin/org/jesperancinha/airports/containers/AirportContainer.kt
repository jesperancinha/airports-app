package org.jesperancinha.airports.containers

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import org.jesperancinha.airports.pojos.Airport
import java.io.InputStreamReader

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
class AirportContainer {
    private val mapper: CsvMapper by lazy { CsvMapper() }
    private val schema: CsvSchema? by lazy {
        CsvSchema.builder()
            .setColumnSeparator(',')
            .addColumn("id")
            .addColumn("ident")
            .addColumn("type")
            .addColumn("name")
            .addColumn("latitudeDeg")
            .addColumn("longitudeDeg")
            .addColumn("elevationFt")
            .addColumn("continent")
            .addColumn("isoCountry")
            .addColumn("isoRegion")
            .addColumn("municipality")
            .addColumn("scheduledService")
            .addColumn("gpsCode")
            .addColumn("iataCode")
            .addColumn("localCode")
            .addColumn("homeLink")
            .addColumn("wikipediaLink")
            .addColumn("keywords")
            .build()
    }
    val airports: List<Airport> by lazy {
        mapper.reader(Airport::class.java)
            .with(schema)
            .readValues<Airport>(
                AirportContainer::class.java.getResourceAsStream("/airports.csv")?.let { InputStreamReader(it) })
            .readAll()
    }
}