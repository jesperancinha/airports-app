package org.jesperancinha.airports.pojos

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
data class Runway(
    val id: String? = null,
    val airportRef: String? = null,
    val airportIdent: String? = null,
    val lengthFt: String? = null,
    val widthFt: String? = null,
    val surface: String? = null,
    val lighted: String? = null,
    val closed: String? = null,
    val leIdent: String? = null,
    val leLatitudeDeg: String? = null,
    val leLongitudeDeg: String? = null,
    val leElevationFt: String? = null,
    val leHeadingDegT: String? = null,
    val leDisplacedThresholdFt: String? = null,
    val heIdent: String? = null,
    val heLatitudeDeg: String? = null,
    val heLongitudeDeg: String? = null,
    val heElevationFt: String? = null,
    val heHeadingDegT: String? = null,
    val heDisplacedThresholdFt: String? = null,
    val heDisplacedThresholdFT: String? = null
)