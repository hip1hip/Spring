package com.example.openmarket.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
  @Autowired
  private OrderService orderService;

  @PostMapping("")
  public Order createOrder(@RequestBody Order order) {
    return orderService.saveOrder(order);
  }

  @GetMapping("")
  public List<Order> getAllOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("/{id}")
  public Order getOrder(@PathVariable int id) {
    return orderService.getOrderById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteOrder(@PathVariable int id) {
    orderService.deleteOrder(id);
  }
}
