package com.ibrahim.ib_shop.Controller;

import com.ibrahim.ib_shop.Model.Customer;
import com.ibrahim.ib_shop.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/customer")
    public ResponseEntity<Customer>  getCustomerById(@PathVariable long custId){
        return new ResponseEntity<>(customerService.getCustomerById(custId), HttpStatus.OK) ;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        try{
            System.out.println(customer);
            return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED) ;
        }catch (Exception e){
            System.out.println("Error adding customer"+ e.getMessage());
            return new ResponseEntity<>(customer, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
