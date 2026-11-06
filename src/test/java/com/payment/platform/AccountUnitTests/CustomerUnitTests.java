package com.payment.platform.AccountUnitTests;

import com.payment.platform.account.domain.Customer;
import com.payment.platform.account.repository.CustomerRepository;
import com.payment.platform.account.serivce.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerUnitTests {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @Test
    void shouldCreateCustomer() {
        UUID uuid = UUID.randomUUID();
        Customer customer = new Customer();
        customer.setId(uuid);
        customer.setEmail("johndoe@gmail.com");
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setCreatedAt(LocalDateTime.now());
        assertNotNull(customer);
        when(customerRepository.save(any(Customer.class)))
                .thenReturn(customer);
        Customer result = customerService.add(customer);
        assertNotNull(result);
        assertEquals(uuid, result.getId());
        assertEquals("johndoe@gmail.com", result.getEmail());
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());

        verify(customerRepository, times(1))
                .save(any(Customer.class));
    }

}
