package com.customer.service.address.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {

    @JsonProperty("cep")
    private String zipcode;

    @JsonProperty("logradouro")
    private String address;

    @JsonProperty("bairro")
    private String county;

    @JsonProperty("localidade")
    private String city;

    @JsonProperty("uf")
    private String state;
}
