package com.ibrahim.ib_shop.Repository;

import com.ibrahim.ib_shop.Model.Customer;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

    boolean existsByUsername(String username);

    Optional<Customer> findByUsername(String username);

}
