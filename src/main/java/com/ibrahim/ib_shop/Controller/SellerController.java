package com.ibrahim.ib_shop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibrahim.ib_shop.Model.Product;
import com.ibrahim.ib_shop.Service.ProductService;
import com.ibrahim.ib_shop.Service.SellerService;

@RestController
@RequestMapping("/api/seller")
public class SellerController {
//    @Autowired
//    SellerService sellerService;
   
    @Autowired
    ProductService productService;

    @GetMapping("{sellerId}/products")
    public ResponseEntity<List<Product>> getSellerProducts(@PathVariable Long sellerId){
        return new ResponseEntity<>(productService.getSellerProducts(sellerId), HttpStatus.OK);
    }

    @GetMapping("{sellerId}/products/{prodId}")
    public ResponseEntity<Product> getSellerProduct1(@PathVariable Long sellerId, @PathVariable Long prodId){
        return new ResponseEntity<>(productService.getSellerProduct1(sellerId, prodId), HttpStatus.OK);
    }

    @PostMapping("{sellerId}/products")
    public ResponseEntity<Product> addSellerProducts(@PathVariable Long sellerId,@RequestBody Product product){
        product.getSeller().setSellerId(sellerId);
        Product createdProduct = productService.addSellerProducts(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.OK);
    }

    @PutMapping("{sellerId}/products/{prodId}")
    public ResponseEntity<Product> editSellerProducts(@PathVariable Long sellerId, @RequestBody Product product){
        product.getSeller().setSellerId(sellerId);
        Product updatedProduct = productService.editSellerProducts(sellerId, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("{sellerId}/products/{prodId}")
    public ResponseEntity<Product> deleteSellerProducts(@PathVariable Long sellerId, @PathVariable Long prodId){
        productService.deleteSellerProducts(sellerId, prodId);
        return ResponseEntity.noContent().build();
    }


}
