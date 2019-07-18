package com.customer.service.address.service;

import com.customer.service.address.model.Address;

public interface AddressService {

    Address getAddress(String zipcode);
}
