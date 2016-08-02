package com.jesperancinha.service.containers;

import com.jesperancinha.service.pojos.Country;
import lombok.Getter;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Getter
public class CountryContainer {

    private Object[] FILE_HEADER = new Object[]{
            "id",
            "code",
            "name",
            "continent",
            "wikipedia_link",
            "keywords"
    };

    private Country country;

    public CountryContainer() {

    }
}
