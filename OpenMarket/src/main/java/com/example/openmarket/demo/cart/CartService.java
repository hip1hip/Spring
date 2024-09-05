package com.example.openmarket.demo.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
  @Autowired
  private CartRepository cartRepository;

  public Cart saveCart(Cart cart) {
    return cartRepository.save(cart);
  }

  public List<Cart> getAllCarts() {
    return cartRepository.findAll();
  }

  public Cart getCartById(int id) {
    return cartRepository.findById(id).orElse(null);
  }

  public void deleteCart(int id) {
    cartRepository.deleteById(id);
  }
}
