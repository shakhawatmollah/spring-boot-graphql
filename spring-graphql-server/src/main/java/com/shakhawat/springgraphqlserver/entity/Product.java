package com.shakhawat.springgraphqlserver.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String category;

    private Float price;

    private Integer stock;

    public Product(String name, String category, float price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public Product() {

    }
}
