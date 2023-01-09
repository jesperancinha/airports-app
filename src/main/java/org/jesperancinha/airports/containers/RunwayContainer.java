package org.jesperancinha.airports.containers;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.jesperancinha.airports.pojos.Runway;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Getter
@Component
public class RunwayContainer {

    private final CsvMapper mapper = new CsvMapper();
    private final CsvSchema schema = CsvSchema.builder()
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
            .build();


    private List<Runway> runways;

    public RunwayContainer() throws IOException {
        runways = new ArrayList<>();
        final InputStream aiportStream = getClass().getResourceAsStream("/runways.csv");
        final MappingIterator<Runway> it = mapper
                .reader(Runway.class)
                .with(schema)
                .readValues(new InputStreamReader(aiportStream));
        runways = it.readAll();
    }
}
