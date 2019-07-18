package com.customer.service.domains.converter;

import com.customer.service.domains.model.City;
import com.customer.service.domains.resource.model.CityResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CityResponseConverter {

    public static List<CityResponse> convert(List<City> cities) {
        return cities.stream()
                .map(city -> CityResponse.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
