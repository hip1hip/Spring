package com.example.openmarket.demo.product;

import com.example.openmarket.demo.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.openmarket.demo.FileStorageService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  private final Path fileStorageLocation;
  private FileStorageService fileStorageService;

  @Autowired
  public ProductService(FileStorageProperties properties) {
    this.fileStorageLocation = Paths.get(properties.getUploadDir())
            .toAbsolutePath().normalize();
    try {
      Files.createDirectories(this.fileStorageLocation);
    } catch (IOException ex) {
      throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
    }
  }

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
      return productRepository.save(product);
    }
    return null;
  }

  public String saveImage(MultipartFile file) throws IOException {
    // 파일 이름 생성
    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
    // 파일 경로 설정
    Path targetLocation = this.fileStorageLocation.resolve(fileName);
    // 파일 저장
    Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
    // 저장된 파일의 경로를 반환 (예: 파일 이름 또는 상대 경로)
    return fileName;
  }

  public Product createProduct(String name, String description, int price, int quantity, MultipartFile image) {
    // 이미지 파일 저장
    String imageUrl = fileStorageService.storeFile(image);

    Product product = new Product();
    product.setName(name);
    product.setDescription(description);
    product.setPrice(price);
    product.setQuantity(quantity);
    product.setImagePath(imageUrl); // 이미지 경로 설정

    return productRepository.save(product);
  }
}
