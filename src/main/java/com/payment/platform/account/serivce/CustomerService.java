package com.payment.platform.account.serivce;

import com.payment.platform.account.domain.Customer;
import com.payment.platform.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer add(Customer customer) {

        Customer newCustomer = new Customer();

        newCustomer.setEmail(customer.getEmail());
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());

        newCustomer.setCreatedAt(LocalDateTime.now());

        return customerRepository.save(newCustomer);
    }
}
