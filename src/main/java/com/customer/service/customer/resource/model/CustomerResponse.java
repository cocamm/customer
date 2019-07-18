package com.customer.service.customer.resource.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class CustomerResponse {

    private Long id;
    private String document;
    private String name;
    private LocalDate birthDate;
    private List<AddressResponse> addresses;
}
