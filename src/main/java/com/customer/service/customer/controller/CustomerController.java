package com.customer.service.customer.controller;

import com.customer.service.customer.resource.CustomerResource;
import com.customer.service.customer.resource.model.AddressRequest;
import com.customer.service.customer.resource.model.CustomerResponse;
import com.customer.service.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.customer.service.customer.resource.converter.CustomerResponseConverter.convert;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController implements CustomerResource {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<CustomerResponse> getCustomer(String document) {
        log.debug("Start method getCustomer with document = {}", document);

        return new ResponseEntity<>(convert(customerService.findCustomer(document)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateCustomerAddress(String document, Long addressId, AddressRequest addressRequest) {
        log.debug("Start method updateCustomerAddress with document = {}, addressId = {}", document, addressId);

        customerService.updateCustomerAddress(document, addressId, addressRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
