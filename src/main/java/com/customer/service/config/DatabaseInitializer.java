package com.customer.service.config;

import com.customer.service.customer.model.Address;
import com.customer.service.customer.model.Customer;
import com.customer.service.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("default")
public class DatabaseInitializer {

    @Component
    public class InitializerRunner implements CommandLineRunner {

        private CustomerRepository customerRepository;

        public InitializerRunner(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        @Override
        public void run(String... args) throws Exception {
            Customer customer = Customer.builder()
                    .name("Customer Name")
                    .document("12345678909")
                    .birthDate(LocalDate.of(1980, 1, 1))
                    .build();

            List<Address> addresses = Arrays.asList(Address.builder()
                            .address("Rua José dos Reis")
                            .number(100)
                            .county("Vila Prudente")
                            .city("São Paulo")
                            .state("SP")
                            .zipCode("03139040")
                            .customer(customer)
                            .build(),
                    Address.builder()
                            .address("Rua José dos Reis")
                            .number(200)
                            .county("Vila Prudente")
                            .city("São Paulo")
                            .state("SP")
                            .zipCode("03139040")
                            .customer(customer)
                            .build());
            customer.setAddresses(addresses );
            customerRepository.save(customer);
        }
    }
}
