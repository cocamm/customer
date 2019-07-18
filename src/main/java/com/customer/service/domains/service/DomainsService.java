package com.customer.service.domains.service;

import com.customer.service.domains.model.City;
import com.customer.service.domains.model.State;

import java.util.List;

public interface DomainsService {

    List<State> getStates();

    List<City> getCities(Long stateId);
}
