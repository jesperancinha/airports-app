package com.jesperancinha.service.resources.query;

import java.io.IOException;

/**
 * Created by joaofilipesabinoesperancinha on 31-07-16.
 */
public class QueryService {
    public QueryProvider getQueryProviderByCountryName(String city) throws IOException {
        return QueryProvider.builder().name("getQueryProviderByCountryName").build();
    }

    public QueryProvider getQueryProviderByCountryCode(String city) throws IOException {
        return QueryProvider.builder().name("getQueryProviderByCountryCode").build();
    }
}
