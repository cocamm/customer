package com.customer.service.customer.mock;

import com.customer.service.customer.model.Address;
import com.customer.service.customer.model.Customer;

import java.time.LocalDate;

public class CustomerMockBuilder {

    public static Customer mockCustomer() {
        return Customer.builder()
                .id(1L)
                .name("Customer Name")
                .document("12345678909")
                .birthDate(LocalDate.of(1980, 1, 1))
                .build();
    }

    public static Address mockAddress() {
        return Address.builder()
                .id(1L)
                .address("Rua José dos Reis")
                .number(100)
                .county("Vila Prudente")
                .city("São Paulo")
                .state("SP")
                .zipCode("03139040")
                .customer(mockCustomer())
                .build();
    }
}
