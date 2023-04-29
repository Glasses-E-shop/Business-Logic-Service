package com.test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product;

    private String name;
    private String price;
    private String diopter;
    private int stock;

    public Product(String name, String price, String diopter, int stock) {
        this.name = name;
        this.price = price;
        this.diopter = diopter;
        this.stock = stock;
    }
}
