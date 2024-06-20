package com.jesperancinha.service.containers;

import com.jesperancinha.service.pojos.Runway;
import lombok.Getter;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Getter
public class RunwayContainer {

    private Object[] FILE_HEADER = new Object[]
            {
                    "id",
                    "airport_ref",
                    "airport_ident",
                    "length_ft",
                    "width_ft",
                    "surface",
                    "lighted",
                    "closed",
                    "le_ident",
                    "le_latitude_deg",
                    "le_longitude_deg",
                    "le_elevation_ft",
                    "le_heading_degT",
                    "le_displaced_threshold_ft",
                    "he_ident",
                    "he_latitude_deg",
                    "he_longitude_deg",
                    "he_elevation_ft",
                    "he_heading_degT",
                    "he_displaced_threshold_ft"
            };

    private Runway runway;

    public RunwayContainer() {

    }
}
