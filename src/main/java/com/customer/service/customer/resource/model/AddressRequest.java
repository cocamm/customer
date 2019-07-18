package com.customer.service.customer.resource.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddressRequest {
    @NotBlank
    private String address;
    @NotNull
    private Integer number;
    private String complement;
    @NotBlank
    private String county;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String zipCode;
}
