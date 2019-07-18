package com.customer.service.address.resource.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {

    private String zipcode;
    private String address;
    private String county;
    private String city;
    private String state;
}
