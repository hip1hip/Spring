package com.example.openmarket.demo.order;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
  private int id;
  private int buyerId;
  private int productId;
  private int quantity;
  private boolean paid;
  private String orderDate;
}

