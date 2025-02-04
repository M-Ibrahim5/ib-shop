package com.ibrahim.ib_shop.DTO;


public class CustomerDTO {
    private Long custId;
    private String username;
    private String email;
    private String address;
    private String phone;
    private int age;

    // Constructors
    public CustomerDTO() {}

    public CustomerDTO(Long custId,String username, String email, String address, String phone, int age) {
        this.username = username;
        this.custId = custId;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.age = age;
    }

    // Getters & Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getCustomerId() { return custId; }
    public void setCustomerId(long custId) { this.custId = custId; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
