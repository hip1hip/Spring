package com.example.openmarket.demo.product;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
  private int id;
  private String name;
  private String description;
  private int price;
  private int quantity;
  private MultipartFile imageFile; // 이미지 파일을 처리하는 필드
}
