package com.ibrahim.ib_shop.Service;

import com.ibrahim.ib_shop.DTO.AuthResponse;
import com.ibrahim.ib_shop.DTO.LoginRequest;
import com.ibrahim.ib_shop.DTO.SignUpRequest;
import com.ibrahim.ib_shop.Model.Customer;
import com.ibrahim.ib_shop.Repository.CustomerRepository;
import com.ibrahim.ib_shop.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private final CustomerRepository customerRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    // final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    private final PasswordEncoder passwordEncoder;


    public AuthService(CustomerRepository customerRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(SignUpRequest signUpRequest) {
        if (customerRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new RuntimeException("Username already taken");
        }

        // Hash the password
        String hashedPassword = passwordEncoder.encode(signUpRequest.getPassword().trim());

        // Create customer object
        Customer customer = new Customer();
        customer.setUsername(signUpRequest.getUsername());
        customer.setPassword(signUpRequest.getPassword());
        customer.setEmail(signUpRequest.getEmail());
        customer.setAddress(signUpRequest.getAddress());
        customer.setAge(signUpRequest.getAge());

        customerRepository.save(customer);
        return "Yes, User successfully registered with username: "+customer.getUsername()+" and password: "+customer.getPassword();
    }

    public AuthResponse loginUser(LoginRequest loginRequest) {
        Optional<Customer> customerOpt = customerRepository.findByUsername(loginRequest.getUsername());
        if (customerOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        Customer customer = customerOpt.get();

//        System.out.println("Password from db: "+ customer.getPassword());
//        System.out.println("Password enetered: "+ loginRequest.getPassword());
//        System.out.println("New Hashed Password: "+ passwordEncoder.encode(customer.getPassword()));

        // Compare raw password with hashed password
//        if (!encoder.matches(loginRequest.getPassword(), customer.getPassword())) {
//            throw new RuntimeException("Invalid hashed Password");
//        }

        // Authenticate user
        if (!verify(loginRequest)) {
            throw new RuntimeException("Verify fail. Invalid Password");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(customer.getUsername());

        return new AuthResponse(token, "Login successful");
    }

    public boolean verify(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername().trim(),
                            loginRequest.getPassword().trim()
                    )
            );
            return authentication.isAuthenticated();
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            return false;
        }
    }
}


