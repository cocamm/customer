package com.customer.service.customer.controller;

import com.customer.service.customer.service.CustomerService;
import com.customer.service.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.customer.service.customer.mock.CustomerMockBuilder.mockCustomer;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void shouldReturnUserSuccessfullyWithHttpStatus200() throws Exception {
        when(customerService.findCustomer(anyString())).thenReturn(mockCustomer());

        this.mockMvc.perform(get("/api/customers/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("document", is("12345678909")))
                .andExpect(jsonPath("birthDate", is("1980-01-01")))
                .andExpect(jsonPath("name", is("Customer Name")));
    }

    @Test
    public void shouldReturnHttpStatus404WhenCustomerNotFound() throws Exception {
        when(customerService.findCustomer(anyString())).thenThrow(NotFoundException.class);

        this.mockMvc.perform(get("/api/customers/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}