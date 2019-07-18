package com.customer.service.domains.resource.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityResponse {

    private Long id;
    private String name;
}
