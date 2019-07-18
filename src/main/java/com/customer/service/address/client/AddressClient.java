package com.customer.service.address.client;

import com.customer.service.address.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AddressClient", url = "${integration.address.uri}")
public interface AddressClient {

    @GetMapping(value = "/{zipcode}/json", consumes = "application/json;charset=UTF-8")
    Address getAddress(@PathVariable("zipcode") String zipcode);
}
