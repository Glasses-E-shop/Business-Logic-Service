package com.test.servicies;

import com.test.dto.AppDTO;
import com.test.entities.Appointment;
import com.test.exceptions.NotFoundException;
import com.test.repositories.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;

    public Appointment add (AppDTO dto) {
        Appointment x = new Appointment(dto.getDate());
        return this.appointmentRepo.save(x);
    }

    public List<Appointment> get() throws NotFoundException {
        if(this.appointmentRepo.findAll().isEmpty()) {
            throw new NotFoundException("Nu exista appointment");
        }
        return this.appointmentRepo.findAll();
    }
    public Optional<Appointment> getById(int id) throws NotFoundException {
        if(this.appointmentRepo.findById(id).isEmpty()) {
            throw new NotFoundException("Nu exista appointment");
        }
        return this.appointmentRepo.findById(id) ;
    }
    public void delete(int id) {
        this.appointmentRepo.deleteById(id);
    }
}
