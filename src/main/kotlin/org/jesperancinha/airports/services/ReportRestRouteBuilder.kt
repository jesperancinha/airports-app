/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jesperancinha.airports.services

import org.apache.camel.builder.RouteBuilder
import org.apache.camel.model.rest.RestBindingMode
import org.springframework.stereotype.Component

/**
 *
 */
@Component
class ReportRestRouteBuilder : RouteBuilder() {
    override fun configure() {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true")
            .contextPath("jesperancinha-airports/rest").port(8080)
        rest("/provider").description("ReportProvider rest airports for Countries")
            .consumes("application/json")
            .produces("application/json")["/tenmostcountriesreport"].description("Find atm by city")
            .outType(ReportProvider::class.java)
            .to("bean:reportService?method=getMostReportProvider()")
        rest("/provider").description("ReportProvider rest airports for Countries")
            .consumes("application/json")
            .produces("application/json")["/tenleastcountriesreport"].description("Find atm by city")
            .outType(ReportProvider::class.java)
            .to("bean:reportService?method=getLeastReportProvider()")
        rest("/provider").description("ReportProvider rest airports for Runaways")
            .consumes("application/json")
            .produces("application/json")["/tenmostrunwaysreport"].description("Find atm by city")
            .outType(ReportProvider::class.java)
            .to("bean:reportService?method=getMostRunwayProvider()")
    }
}