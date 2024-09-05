package com.example.openmarket.demo.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDao  extends JpaRepository<Seller, Integer> {
}
