package com.test.repositories;

import com.test.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
}