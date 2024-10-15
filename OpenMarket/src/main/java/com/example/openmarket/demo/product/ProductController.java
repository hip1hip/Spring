package com.example.openmarket.demo.product;

import com.example.openmarket.demo.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private FileStorageService fileStorageService;

  // 상품 등록 (이미지 파일 포함)
  @PostMapping("")
  public Product createProduct(
          @RequestParam("name") String name,
          @RequestParam("description") String description,
          @RequestParam("price") int price,
          @RequestParam("quantity") int quantity,
          @RequestParam("image") MultipartFile image) {

    // 이미지 파일을 저장하고, 파일 경로를 반환하는 코드 필요
    String imagePath = fileStorageService.save(image); // 파일 저장 후 URL 또는 경로를 반환

    Product product = new Product();
    product.setName(name);
    product.setDescription(description);
    product.setPrice(price);
    product.setQuantity(quantity);
    product.setImagePath(imagePath); // 이미지 경로 설정
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
