package com.ibrahim.ib_shop.Repository;

import com.ibrahim.ib_shop.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
