package com.jesperancinha.service.services;

import com.jesperancinha.service.containers.MainContainerService;
import com.jesperancinha.service.pojos.Airport;
import com.jesperancinha.service.pojos.Runway;
import org.apache.camel.BeanInject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */

@Component
@Service(value = "reportAirportService")
public class ReportAirportServiceImpl implements ReportAirportService {

    @BeanInject
    MainContainerService mainContainerService;

    @Override
    public Map<String, Long> getCountriesWithHighestNumberOfAirports(int listSize) {
        List<Airport> listOfAirports = mainContainerService.getFullAiportInfo();
        Map<String, Long> topTen = listOfAirports
                .stream()
                .sorted((o1, o2) -> o1.getIsoCountry().compareTo(o2.getIsoCountry()))
                .collect(Collectors.groupingBy(Airport::getIsoCountry, Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) ->
                        e2.getValue().compareTo(e1.getValue()))
                .limit(listSize)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        return topTen;
    }

    @Override
    public Map<String, Long> getCountriesWithLowesNumberOfAirports(int listSize) {
        List<Airport> listOfAirports = mainContainerService.getFullAiportInfo();
        Map<String, Long> topLowest = listOfAirports
                .stream()
                .sorted((o1, o2) -> o1.getIsoCountry().compareTo(o2.getIsoCountry()))
                .collect(Collectors.groupingBy(Airport::getIsoCountry, Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) ->
                        e1.getValue().compareTo(e2.getValue()))
                .limit(listSize)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        return topLowest;
    }

    @Override
    public List<Runway> getRunwaysMostCommonlyIdentified(int listSize) {
        return null;
    }
}
