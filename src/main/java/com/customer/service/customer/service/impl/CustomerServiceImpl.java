package com.customer.service.customer.service.impl;

import com.customer.service.customer.model.Address;
import com.customer.service.customer.model.Customer;
import com.customer.service.customer.repository.AddressRepository;
import com.customer.service.customer.repository.CustomerRepository;
import com.customer.service.customer.resource.model.AddressRequest;
import com.customer.service.customer.service.CustomerService;
import com.customer.service.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Customer findCustomer(String document) {
        log.debug("findCustomer with document = {}", document);

        return customerRepository.findFirstByDocument(document)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
    }

    @Override
    public void updateCustomerAddress(String document, Long addressId, AddressRequest addressRequest) {
        Address address = addressRepository.findFirstByIdAndCustomer_document(addressId, document)
                .orElseThrow(() -> new NotFoundException("Address not found"));
        address.setAddress(addressRequest.getAddress());
        address.setNumber(addressRequest.getNumber());
        address.setComplement(addressRequest.getComplement());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setZipCode(addressRequest.getZipCode());

        addressRepository.save(address);
    }
}
