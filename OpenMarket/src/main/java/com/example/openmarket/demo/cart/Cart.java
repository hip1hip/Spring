package com.example.openmarket.demo.cart;

import com.example.openmarket.demo.buyer.Buyer;
import com.example.openmarket.demo.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Buyer buyer;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Product product;

  private int quantity;
}
