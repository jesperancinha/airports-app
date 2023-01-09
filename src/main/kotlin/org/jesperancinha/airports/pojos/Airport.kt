package org.jesperancinha.airports.pojos

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
data class Airport(
    @JsonProperty("id")
    val id: String? = null,
    @JsonProperty("ident")
    val ident: String? = null,
    @JsonProperty("type")
    val type: String? = null,
    @JsonProperty("name")
    val name: String? = null,
    @JsonProperty("latitudeDeg")
    val latitudeDeg: String? = null,
    @JsonProperty("longitudeDeg")
    val longitudeDeg: String? = null,
    @JsonProperty("elevationFt")
    val elevationFt: String? = null,
    @JsonProperty("continent")
    val continent: String? = null,
    @JsonProperty("isoCountry")
    val isoCountry: String,
    @JsonProperty("isoRegion")
    val isoRegion: String? = null,
    @JsonProperty("municipality")
    val municipality: String? = null,
    @JsonProperty("scheduledService")
    val scheduledService: String? = null,
    @JsonProperty("gpsCode")
    val gpsCode: String? = null,
    @JsonProperty("iataCode")
    val iataCode: String? = null,
    @JsonProperty("localCode")
    val localCode: String? = null,
    @JsonProperty("homeLink")
    val homeLink: String? = null,
    @JsonProperty("wikipediaLink")
    val wikipediaLink: String? = null,
    @JsonProperty("keywords")
    val keywords: String? = null,
    @JsonProperty("country")
    var country: Country?=null,
) {
    val runways: MutableList<Runway> = mutableListOf()

    fun addRunWay(runway: Runway) {
        runways.add(runway)
    }
}