package com.customer.service.domains.client;

import com.customer.service.domains.model.City;
import com.customer.service.domains.model.State;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "StateClient", url = "${integration.state.uri}")
public interface StateClient {

    @GetMapping(value = "/localidades/estados", headers = { "Accept-Encoding: gzip" }, consumes = "application/json;charset=UTF-8")
    List<State> getStates();

    @GetMapping(value = "/localidades/estados/{id}/municipios", consumes = "application/json;charset=UTF-8")
    List<City> getCities(@PathVariable("id") Long stateId);
}
