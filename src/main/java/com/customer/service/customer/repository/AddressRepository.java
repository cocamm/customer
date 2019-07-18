package com.customer.service.customer.repository;

import com.customer.service.customer.model.Address;
import com.customer.service.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findFirstByIdAndCustomer_document(Long id, String document);

}
