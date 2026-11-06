package com.payment.platform.account.api;

import com.payment.platform.account.domain.Customer;
import com.payment.platform.account.serivce.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    private ResponseEntity<Customer> add(@RequestBody Customer customer) {

        Customer newCustomer = new Customer();

        newCustomer.setEmail(customer.getEmail());
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());

        newCustomer.setCreatedAt(LocalDateTime.now());

        Customer savedCustomer = customerService.add(newCustomer);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
}
