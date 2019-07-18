package com.customer.service.customer.resource.converter;

import com.customer.service.customer.model.Customer;
import com.customer.service.customer.resource.model.AddressResponse;
import com.customer.service.customer.resource.model.CustomerResponse;

import java.util.stream.Collectors;

public class CustomerResponseConverter {

    public static CustomerResponse convert(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .document(customer.getDocument())
                .birthDate(customer.getBirthDate())
                .name(customer.getName())
                .addresses(customer.getAddresses().stream()
                        .map(address -> AddressResponse.builder()
                                .addressId(address.getId())
                                .zipCode(address.getZipCode())
                                .address(address.getAddress())
                                .number(address.getNumber())
                                .complement(address.getComplement())
                                .county(address.getCounty())
                                .city(address.getCity())
                                .state(address.getState())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
