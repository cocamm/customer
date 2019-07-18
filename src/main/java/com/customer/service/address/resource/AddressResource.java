package com.customer.service.address.resource;

import com.customer.service.address.resource.model.AddressResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface AddressResource {

    @GetMapping(value = "/addresses/{zipcode}", produces = "application/json;charset=UTF-8")
    ResponseEntity<AddressResponse> getAddress(@PathVariable("zipcode") String zipcode);
}
