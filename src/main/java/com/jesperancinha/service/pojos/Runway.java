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

    private String lighted;

    private String closed;

    private String leIdent;

    private String leLatitudeDeg;

    private String letLongitudeDeg;

    private String leElevationFt;

    private String leLeadingDegT;

    private String leDisplacedThresholdFt;

    private String heIdent;

    private String heLatitudeDeg;

    private String heLongitudeDeg;

    private String heElevationFt;

    private String heHeadingDegT;

    private String heDisplacedThresholdFT;

}
