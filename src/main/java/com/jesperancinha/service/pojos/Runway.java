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
public class Runway {

    private String id;

    private String airportRef;

    private String airportIdent;

    private String lengthFt;

    private String widthFt;

    private String surface;

    private String lighted;

    private String closed;

    private String leIdent;

    private String leLatitudeDeg;

    private String leLongitudeDeg;

    private String leElevationFt;

    private String leHeadingDegT;

    private String leDisplacedThresholdFt;

    private String heIdent;

    private String heLatitudeDeg;

    private String heLongitudeDeg;

    private String heElevationFt;

    private String heHeadingDegT;

    private String heDisplacedThresholdFt;

    private String heDisplacedThresholdFT;

}
