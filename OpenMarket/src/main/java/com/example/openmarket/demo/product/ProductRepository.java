package com.example.openmarket.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  // 추가로 필요한 상품 검색 기능을 여기에 정의할 수 있습니다.
}
