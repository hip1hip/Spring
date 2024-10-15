package com.example.openmarket.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;

  public Order saveOrder(Order order) {
    return orderRepository.save(order);
  }

  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  public Order getOrderById(int id) {
    return orderRepository.findById(id).orElse(null);
  }

  public void deleteOrder(int id) {
    orderRepository.deleteById(id);
  }
}
