package org.jesperancinha.airports.containers;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.jesperancinha.airports.pojos.Airport;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Getter
public class AirportContainer {

    private final CsvMapper mapper = new CsvMapper();
    private final CsvSchema schema = CsvSchema.builder()
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
            .build();


    private List<Airport> airports;

    public AirportContainer() throws IOException {
        airports = new ArrayList<>();
        final InputStream aiportStream = getClass().getResourceAsStream("/airports.csv");
        final MappingIterator<Airport> it = mapper
                .reader(Airport.class)
                .with(schema)
                .readValues(new InputStreamReader(aiportStream));
        airports = it.readAll();
    }
}
