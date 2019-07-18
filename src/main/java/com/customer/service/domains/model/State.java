package com.customer.service.domains.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class State {

    private Long id;

    @JsonProperty("sigla")
    private String code;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("regiao")
    private Region region;
}
