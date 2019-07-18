package com.customer.service.domains.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class City {

    private Long id;

    @JsonProperty("nome")
    private String name;
}
