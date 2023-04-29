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
public class Order_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;
    private String status;

    public Order_entity(String status) {
        this.status = status;
    }
}
