package com.example.openmarket.demo.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
  @Autowired
  private CartService cartService;

  @PostMapping("")
  public Cart createCart(@RequestBody Cart cart) {
    return cartService.saveCart(cart);
  }

  @GetMapping("")
  public List<Cart> getAllCarts() {
    return cartService.getAllCarts();
  }

  @GetMapping("/{id}")
  public Cart getCart(@PathVariable int id) {
    return cartService.getCartById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteCart(@PathVariable int id) {
    cartService.deleteCart(id);
  }
}
