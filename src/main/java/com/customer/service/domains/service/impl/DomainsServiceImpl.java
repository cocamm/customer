package com.customer.service.domains.service.impl;

import com.customer.service.domains.client.StateClient;
import com.customer.service.domains.model.City;
import com.customer.service.domains.model.State;
import com.customer.service.domains.service.DomainsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DomainsServiceImpl implements DomainsService {

    private final StateClient client;

    public DomainsServiceImpl(StateClient client) {
        this.client = client;
    }

    @Override
    public List<State> getStates() {
        return client.getStates();
    }

    @Override
    public List<City> getCities(Long stateId) {
        log.debug("getCities with stateId = {}", stateId);

        return client.getCities(stateId);
    }
}
