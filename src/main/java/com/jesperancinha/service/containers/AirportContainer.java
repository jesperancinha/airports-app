package com.jesperancinha.service.containers;

import com.jesperancinha.service.pojos.Airport;
import lombok.Getter;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Getter
public class AirportContainer {

    private Object[] FILE_HEADER = new Object[] {
            "id",
            "ident",
            "type",
            "name",
            "latitude_deg",
            "longitude_deg",
            "elevation_ft",
            "continent",
            "iso_country",
            "iso_region",
            "municipality",
            "scheduled_service",
            "gps_code",
            "iata_code",
            "local_code",
            "home_link",
            "wikipedia_link",
            "keywords"
    };

    private Airport airport;

    public AirportContainer(){

    }
}
