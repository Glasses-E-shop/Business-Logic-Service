package com.test.controllers;

import com.test.dto.AppDTO;
import com.test.entities.Appointment;
import com.test.exceptions.NotFoundException;
import com.test.servicies.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    @ResponseBody
    public AppDTO add(@RequestBody AppDTO a) {
        Appointment nou = this.appointmentService.add(a);
        return a;
    }
    @GetMapping
    @ResponseBody
    public List<Appointment> get() throws NotFoundException {
        return this.appointmentService.get();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<Appointment> getById(@PathVariable(name="id") int id) throws NotFoundException {
        return this.appointmentService.getById(id);
    }

    @DeleteMapping(path="/{id}")
    @ResponseBody
    public String delete(@PathVariable(name="id") int id) {
        this.appointmentService.delete(id);
        return "Cancelled appointment with id: " + id;
    }
}
