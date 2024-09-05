package com.example.openmarket.demo.product;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
  private int id;
  private String name;
  private String description;
  private int price;
  private int quantity;
  private String imageUrl;
}
