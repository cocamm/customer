package com.customer.service.domains.resource;

import com.customer.service.domains.resource.model.CityResponse;
import com.customer.service.domains.resource.model.StateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DomainsResource {

    @GetMapping(value = "/domains/states")
    ResponseEntity<List<StateResponse>> getStates();

    @GetMapping(value = "/domains/states/{stateId}/cities")
    ResponseEntity<List<CityResponse>> getCities(@PathVariable("stateId") Long stateId);
}
