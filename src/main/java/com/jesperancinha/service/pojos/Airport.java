package com.jesperancinha.service.pojos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Getter
@Setter
public class Airport {

    private String id;

    private String ident;

    private String type;

    private String name;

    private String latitudeDeg;

    private String longitudeDeg;

    private String elevationFt;

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

    private Country country;

    private List<Runway> runways;

    public Airport() {
        runways = new ArrayList<>();
    }

    public void addRunWay(Runway runway) {
        runways.add(runway);
    }
}
