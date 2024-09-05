package com.example.openmarket.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product getProductById(int id) {
    return productRepository.findById(id).orElse(null);
  }

  public void deleteProduct(int id) {
    productRepository.deleteById(id);
  }

  public Product updateProduct(int id, Product productDetails) {
    Product product = productRepository.findById(id).orElse(null);
    if (product != null) {
      product.setName(productDetails.getName());
      product.setDescription(productDetails.getDescription());
      product.setPrice(productDetails.getPrice());
      product.setQuantity(productDetails.getQuantity());
      product.setImageUrl(productDetails.getImageUrl());
      return productRepository.save(product);
    }
    return null;
  }
}
