package org.jesperancinha.airports.containers

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import org.jesperancinha.airports.pojos.Runway
import org.springframework.stereotype.Component
import java.io.InputStreamReader

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Component
class RunwayContainer {
    private val mapper = CsvMapper()
    private val schema = CsvSchema.builder()
        .addColumn("id")
        .addColumn("airportRef")
        .addColumn("airportIdent")
        .addColumn("lengthFt")
        .addColumn("widthFt")
        .addColumn("surface")
        .addColumn("lighted")
        .addColumn("closed")
        .addColumn("leIdent")
        .addColumn("leLatitudeDeg")
        .addColumn("leLongitudeDeg")
        .addColumn("leElevationFt")
        .addColumn("leHeadingDegT")
        .addColumn("leDisplacedThresholdFt")
        .addColumn("heIdent")
        .addColumn("heLatitudeDeg")
        .addColumn("heLongitudeDeg")
        .addColumn("heElevationFt")
        .addColumn("heHeadingDegT")
        .addColumn("heDisplacedThresholdFt")
        .build()
    var runways: List<Runway> = ArrayList()

    init {
        val aiportStream = javaClass.getResourceAsStream("/runways.csv")
        val it = mapper
            .reader(Runway::class.java)
            .with(schema)
            .readValues<Runway>(InputStreamReader(aiportStream))
        runways = it.readAll()
    }
}