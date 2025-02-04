package com.ibrahim.ib_shop.Service;

import com.ibrahim.ib_shop.DTO.CustomerDTO;
import com.ibrahim.ib_shop.Model.Customer;
import com.ibrahim.ib_shop.Repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public CustomerDTO updateCustomer(CustomerDTO customerDTO, long custId){
        Optional<Customer> customerOptional = customerRepository.findById(custId);

        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();

            // we need to check if the username is already taken or not
            if( !customer.getUsername().equals(customerDTO.getUsername())
            && customerRepository.existsByUsername(customerDTO.getUsername())){
                throw new DataIntegrityViolationException("Username already exist");
            }

            customer.setUsername(customerDTO.getUsername());
            customer.setEmail(customerDTO.getEmail());
            customer.setPhone(customerDTO.getPhone());
            customer.setAddress(customerDTO.getAddress());
            customer.setAge(customerDTO.getAge());

            Customer updatedCustomer = customerRepository.save(customer);
            return new CustomerDTO(
                    updatedCustomer.getCustomerid(),
                    updatedCustomer.getUsername(),
                    updatedCustomer.getEmail(),
                    updatedCustomer.getPhone(),
                    updatedCustomer.getAddress(),
                    updatedCustomer.getAge()
            );
        }
        else{
            throw new EntityNotFoundException("Customer with id "+ custId+" is not found");
        }
    }

    public void deleteCustomer(Long custId) {
        if(customerRepository.existsById(custId)){
            customerRepository.deleteById(custId);
        }else{
            throw new EntityNotFoundException("Customer with id "+custId+" is not found");
        }
    }
}
