package com.customer.service.customer.service.impl;

import com.customer.service.customer.model.Address;
import com.customer.service.customer.model.Customer;
import com.customer.service.customer.repository.AddressRepository;
import com.customer.service.customer.repository.CustomerRepository;
import com.customer.service.customer.resource.model.AddressRequest;
import com.customer.service.customer.service.CustomerService;
import com.customer.service.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.customer.service.customer.mock.CustomerMockBuilder.mockAddress;
import static com.customer.service.customer.mock.CustomerMockBuilder.mockCustomer;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private AddressRepository addressRepository;

    private CustomerService customerService;

    @Before
    public void init() {
        initMocks(this);

        customerService = new CustomerServiceImpl(customerRepository, addressRepository);
    }

    @Test
    public void shouldReturnCustomer() {
        when(customerRepository.findFirstByDocument(anyString())).thenReturn(Optional.of(mockCustomer()));

        Customer customer = customerService.findCustomer("12345678909");

        assertThat(customer, notNullValue());
        assertThat(customer.getDocument(), is("12345678909"));
    }

    @Test(expected = NotFoundException.class)
    public void shouldReturnNotFoundExceptionWhenCustomerNotFound() {
        when(customerRepository.findFirstByDocument(anyString())).thenReturn(Optional.empty());

        customerService.findCustomer("12345678909");
    }

    @Test
    public void shouldUpdateCustomer() {
        when(addressRepository.findFirstByIdAndCustomer_document(anyLong(), anyString()))
                .thenReturn(Optional.of(mockAddress()));

        customerService.updateCustomerAddress("12345678909", 1L, new AddressRequest());

        verify(addressRepository).save(any(Address.class));
    }

    @Test(expected = NotFoundException.class)
    public void shouldReturnNotFoundExceptionWhenCustomerAddressNotFound() {
        when(addressRepository.findFirstByIdAndCustomer_document(anyLong(), anyString()))
                .thenReturn(Optional.empty());

        customerService.updateCustomerAddress("12345678909", 1L, new AddressRequest());
    }

}