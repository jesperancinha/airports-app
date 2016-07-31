package com.jesperancinha.service.pojos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Getter
@Setter
@NoArgsConstructor
public class Airport {

    private String id;

    private String ident;

    private String type;

    private String name;

    private String latitudeDeg;

    private String longitudeDeg;

    private String elevation_ft;

    private String continent;

    private String isoCountry;

    private String isoRegion;

    private String municipality;

    private String scheduledService;

    private String gpsCode;

    private String iataCode;

    private String localCode;

    private String homeLink;

    private String wikipediaLink;

    private String keywords;

}
