package com.example.openmarket.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  // 상품 등록
  @PostMapping("")
  public Product createProduct(@RequestBody Product product) {
    return productService.saveProduct(product);
  }

  // 전체 상품 목록 조회
  @GetMapping("")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  // 특정 상품 조회 (ID로 검색)
  @GetMapping("/{id}")
  public Product getProductById(@PathVariable int id) {
    return productService.getProductById(id);
  }

  // 상품 수정
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
    return productService.updateProduct(id, product);
  }

  // 상품 삭제
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable int id) {
    productService.deleteProduct(id);
  }
}
