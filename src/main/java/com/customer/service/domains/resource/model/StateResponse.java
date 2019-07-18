package com.customer.service.domains.resource.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StateResponse {

    private Long id;
    private String code;
    private String name;
}
