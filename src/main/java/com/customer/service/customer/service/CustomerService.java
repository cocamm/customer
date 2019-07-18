package com.customer.service.customer.service;

import com.customer.service.customer.model.Customer;
import com.customer.service.customer.resource.model.AddressRequest;
import org.hibernate.validator.constraints.br.CPF;

public interface CustomerService {

    Customer findCustomer(@CPF(message = "{invalid.document}") String document);

    void updateCustomerAddress(String document, Long addressId, AddressRequest addressRequest);
}
