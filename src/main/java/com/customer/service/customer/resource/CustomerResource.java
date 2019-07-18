package com.customer.service.customer.resource;

import com.customer.service.customer.resource.model.AddressRequest;
import com.customer.service.customer.resource.model.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


public interface CustomerResource {

    @GetMapping(value = "/customers/{document}", produces = "application/json;charset=UTF-8")
    ResponseEntity<CustomerResponse> getCustomer(@PathVariable("document") String document);

    @PutMapping(value = "/customers/{document}/addresses/{addressId}", produces = "application/json;charset=UTF-8")
    ResponseEntity<Void> updateCustomerAddress(@PathVariable("document") String document,
                                               @PathVariable("addressId") Long addressId,
                                               @RequestBody @Valid AddressRequest addressRequest);
}
