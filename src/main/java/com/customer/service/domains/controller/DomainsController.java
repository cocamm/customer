package com.customer.service.domains.controller;

import com.customer.service.domains.converter.CityResponseConverter;
import com.customer.service.domains.converter.StateResponseConverter;
import com.customer.service.domains.resource.DomainsResource;
import com.customer.service.domains.resource.model.CityResponse;
import com.customer.service.domains.resource.model.StateResponse;
import com.customer.service.domains.service.DomainsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
@Slf4j
public class DomainsController implements DomainsResource {

    private final DomainsService domainsService;

    public DomainsController(DomainsService domainsService) {
        this.domainsService = domainsService;
    }

    @Override
    public ResponseEntity<List<StateResponse>> getStates() {
        log.debug("Start method getStates");

        return new ResponseEntity<>(StateResponseConverter.convert(domainsService.getStates()), OK);
    }

    @Override
    public ResponseEntity<List<CityResponse>> getCities(Long stateId) {
        log.debug("Start method getCities with stateId = {}", stateId);

        return new ResponseEntity<>(CityResponseConverter.convert(domainsService.getCities(stateId)), OK);
    }
}
