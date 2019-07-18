package com.customer.service.address.service.impl;

import com.customer.service.address.client.AddressClient;
import com.customer.service.address.model.Address;
import com.customer.service.address.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressClient addressClient;

    public AddressServiceImpl(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    @Override
    public Address getAddress(String zipcode) {
        log.debug("getAddress with zipcode = {}", zipcode);

        return addressClient.getAddress(zipcode);
    }
}
