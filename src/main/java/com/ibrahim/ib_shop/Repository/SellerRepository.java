package com.ibrahim.ib_shop.Repository;

import com.ibrahim.ib_shop.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Long> {

}
