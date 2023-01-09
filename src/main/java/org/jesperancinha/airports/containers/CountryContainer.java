package org.jesperancinha.airports.containers;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.jesperancinha.airports.pojos.Country;
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
public class CountryContainer {

    private final CsvMapper mapper = new CsvMapper();
    private final CsvSchema schema = CsvSchema.builder()
            .setColumnSeparator(',')
            .addColumn("id")
            .addColumn("code")
            .addColumn("name")
            .addColumn("continent")
            .addColumn("wikipediaLink")
            .addColumn("keywords")
            .build();

    private List<Country> countries;

    public CountryContainer() throws IOException {
        countries = new ArrayList<>();
        final InputStream aiportStream = getClass().getResourceAsStream("/countries.csv");
        final MappingIterator<Country> it = mapper
                .reader(Country.class)
                .with(schema)
                .readValues(new InputStreamReader(aiportStream));
        countries = it.readAll();
    }
}
