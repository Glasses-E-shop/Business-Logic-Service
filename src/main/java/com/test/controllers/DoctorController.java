package com.test.controllers;

import com.test.dto.DoctorDTO;
import com.test.entities.Doctor;
import com.test.exceptions.NotFoundException;
import com.test.servicies.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @PostMapping
    @ResponseBody
    public DoctorDTO addDoctor(@RequestBody DoctorDTO d) {
        Doctor nou = this.doctorService.add(d);
        return d;
    }
    @GetMapping
    @ResponseBody
    public List<Doctor> getDoctors() throws NotFoundException {
        return this.doctorService.getDoctors();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Optional<Doctor> getDoctor(@PathVariable(name="id") int id) throws NotFoundException {

        return this.doctorService.getDoctor(id);
    }

    @DeleteMapping(path="/{id}")
    @ResponseBody
    public String delDoctor(@PathVariable(name="id") int id) {
        this.doctorService.delDoctor(id);
        return "Deleted doctor with id: " + id;
    }
}
