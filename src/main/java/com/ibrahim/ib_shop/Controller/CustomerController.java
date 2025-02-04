package com.ibrahim.ib_shop.Controller;

import com.ibrahim.ib_shop.DTO.CustomerDTO;
import com.ibrahim.ib_shop.Model.Customer;
import com.ibrahim.ib_shop.Service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/customer/{custId}")
    public ResponseEntity<Customer>  getCustomerById(@PathVariable long custId){
        return new ResponseEntity<>(customerService.getCustomerById(custId), HttpStatus.OK) ;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        try{
            System.out.println(customer);
            return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED) ;
        }catch (Exception e){
            System.out.println("Error adding customer "+ e.getMessage());
            return new ResponseEntity<>(customer, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customer/{custId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable long custId, @RequestBody CustomerDTO customerDTO){
        CustomerDTO updatedCustomer = customerService.updateCustomer(customerDTO, custId) ;

        if(updatedCustomer !=null){
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( updatedCustomer, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/customer/{custId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long custId){
        try{
            customerService.deleteCustomer(custId);
            return new ResponseEntity<>("Customer Deleted with Id: " +custId, HttpStatus.OK);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
