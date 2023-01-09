package org.jesperancinha.airports.resources.query;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class QueryRestRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true")
            .contextPath("jesperancinha-airports/rest").port(8080);

        rest("/provider").description("QueryProvider rest airports")
            .consumes("application/json").produces("application/json")
            .get("/{countryname}/airports/countryname").description("Find airport by coutry name").outType(QueryProvider.class)
                .to("bean:queryService?method=getQueryProviderByCountryName(${header.countryname})");

        rest("/provider").description("QueryProvider rest airports")
            .consumes("application/json").produces("application/json")
            .get("/{countrycode}/airports/countrycode").description("Find airport by country code").outType(QueryProvider.class)
                .to("bean:queryService?method=getQueryProviderByCountryCode(${header.countrycode})");
    }

}