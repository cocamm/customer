package com.customer.service.address.resource.converter;

import com.customer.service.address.model.Address;
import com.customer.service.address.resource.model.AddressResponse;

public class AddressResponseConverter {

    public static AddressResponse convert(Address address) {
        return AddressResponse.builder()
                .zipcode(address.getZipcode())
                .address(address.getAddress())
                .county(address.getCounty())
                .city(address.getCity())
                .state(address.getState())
                .build();
    }
}
