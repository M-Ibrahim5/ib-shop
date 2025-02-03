package com.ibrahim.ib_shop.Service;

import com.ibrahim.ib_shop.Model.Customer;
import com.ibrahim.ib_shop.Repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        List<Customer> customers = customerRepository.findAll();

        return customers;
    }

    public Customer getCustomerById(long custId) {
        Optional<Customer> customer = customerRepository.findById(custId);

        if(customer.isPresent()){
            return customer.get();
        }else{
            throw new EntityNotFoundException("Customer with the Id: "+ custId + " is not found");
        }

    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
