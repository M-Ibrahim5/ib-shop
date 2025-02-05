package com.ibrahim.ib_shop.Service;

import com.ibrahim.ib_shop.Model.Customer;
import com.ibrahim.ib_shop.Repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public CustomUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByUsername(username);

        if (customer.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username.trim());
        }

        return User.builder()
                .username(customer.get().getUsername())
                .password(customer.get().getPassword())
                .roles("USER") // Add roles if needed
                .build();
    }
}
