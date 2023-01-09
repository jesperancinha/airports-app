package org.jesperancinha.airports.containers;

import org.jesperancinha.airports.pojos.Country;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
public class CountryContainerTest {
    @Test
    public void getCountries() throws Exception {
        final CountryContainer airportContainer = new CountryContainer();

        List<Country> countries = airportContainer.getCountries();
        Country country = countries.get(0);

        assertThat(countries, hasSize(248));
        assertThat(country.getId(), notNullValue());
    }

}