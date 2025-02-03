package com.ibrahim.ib_shop.Model;

import jakarta.persistence.*;


@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerid;

    @Column(unique = true, nullable = false) // make the username unique and set it to no null
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String emel;


    private String address;
    private int age;

    public Customer() {
    }

    public Customer(Long customerId, int age, String emel, String address, String password, String username) {
        this.customerid = customerId;
        this.age = age;
        this.emel = emel;
        this.address = address;
        this.password = password;
        this.username = username;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmel() {
        return emel;
    }

    public void setEmel(String emel) {
        this.emel = emel;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

