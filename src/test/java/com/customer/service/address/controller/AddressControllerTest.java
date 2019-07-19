package com.customer.service.address.controller;

import com.customer.service.address.model.Address;
import com.customer.service.address.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    @Test
    public void shouldReturnUserSuccessfullyWithHttpStatus200() throws Exception {
        when(addressService.getAddress(anyString())).thenReturn(Address.builder()
                .address("Rua José dos Reis")
                .county("Vila Prudente")
                .city("São Paulo")
                .state("SP")
                .zipcode("03139040")
                .build());

        this.mockMvc.perform(get("/api/addresses/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}