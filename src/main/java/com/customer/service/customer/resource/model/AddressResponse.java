package com.customer.service.customer.resource.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {

    private Long addressId;
    private String address;
    private Integer number;
    private String complement;
    private String county;
    private String city;
    private String state;
    private String zipCode;
}
