package com.customer.service.address.controller;

import com.customer.service.address.resource.AddressResource;
import com.customer.service.address.resource.model.AddressResponse;
import com.customer.service.address.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.customer.service.address.resource.converter.AddressResponseConverter.convert;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
@Slf4j
public class AddressController implements AddressResource {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public ResponseEntity<AddressResponse> getAddress(String zipcode) {
        log.debug("Start method getAddress with zipcode = {}", zipcode);

        return new ResponseEntity<>(convert(addressService.getAddress(zipcode)), OK);
    }
}
