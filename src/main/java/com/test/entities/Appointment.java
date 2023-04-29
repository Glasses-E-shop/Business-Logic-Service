package com.test.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_appointment;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor id_doctor;

    public Appointment(Date date) {
        this.date = date;
    }
}
