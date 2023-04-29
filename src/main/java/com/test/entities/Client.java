package com.test.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String gender;
    private int age;
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order_entity id_order;
    @ManyToOne
    @JoinColumn(name = "id_appointment")
    private Appointment id_appointment;

    public Client(String username, String password, String gender, int age) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }
}
