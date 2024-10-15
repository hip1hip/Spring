package com.example.openmarket.demo.order;

import com.example.openmarket.demo.product.Product;
import jakarta.persistence.*;
import lombok.*;


import java.sql.Date;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Table(name = "orders") // 테이블 이름을 "orders"로 변경
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Product product;

    private int quantity;
    private boolean paid;
    private Date orderDate;
}