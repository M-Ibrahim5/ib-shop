package com.ibrahim.ib_shop.Service;

import com.ibrahim.ib_shop.Model.Customer;
import com.ibrahim.ib_shop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        List<Customer> customers = customerRepository.findAll();

        return customers;
    }

}
