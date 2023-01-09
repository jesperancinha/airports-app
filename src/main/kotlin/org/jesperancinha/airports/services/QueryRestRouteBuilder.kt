package org.jesperancinha.airports.services

import org.apache.camel.builder.RouteBuilder
import org.apache.camel.model.rest.RestBindingMode
import org.springframework.stereotype.Component

@Component
class QueryRestRouteBuilder : RouteBuilder() {
    @Throws(Exception::class)
    override fun configure() {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true")
            .contextPath("jesperancinha-airports/rest").port(8080)
//        rest("/provider").description("QueryProvider rest airports")
//            .consumes("application/json")
//            .produces("application/json")["/{countryname}/airports/countryname"].description("Find airport by coutry name")
//            .outType(QueryProvider::class.java)
//            .to("bean:queryService?method=getQueryProviderByCountryName(\${header.countryname})")
        rest("/provider").description("QueryProvider rest airports")
            .consumes("application/json")
            .produces("application/json")["/{countrycode}/airports/countrycode"].description("Find airport by country code")
            .outType(QueryProvider::class.java)
            .to("bean:queryService?method=getQueryProviderByCountryCode(\${header.countrycode})")
    }
}