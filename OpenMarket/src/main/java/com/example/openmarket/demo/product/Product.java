package com.example.openmarket.demo.product;

import com.example.openmarket.demo.seller.Seller;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private int price;
    private int quantity;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller; // 다대일 관계

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category; // 다대일 관계

}

