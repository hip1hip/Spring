package com.example.openmarket.demo.cart;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
  private int id;
  private int buyerId;
  private int productId;
  private int quantity;
}
