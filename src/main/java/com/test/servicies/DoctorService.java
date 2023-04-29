package com.test.servicies;

import com.test.dto.ClientDTO;
import com.test.dto.DoctorDTO;
import com.test.entities.Doctor;
import com.test.exceptions.NotFoundException;
import com.test.repositories.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    public Doctor add (DoctorDTO doc) {
        Doctor x = new Doctor(doc.getLast_name(), doc.getFirst_name());
        return this.doctorRepo.save(x);
    }

    public List<Doctor> getDoctors() throws NotFoundException {
        if(this.doctorRepo.findAll().isEmpty()) {
            throw new NotFoundException("Nu exista doctori");
        }
        return this.doctorRepo.findAll();
    }
    public Optional<Doctor> getDoctor(int id) throws NotFoundException {
        if(this.doctorRepo.findById(id).isEmpty()) {
            throw new NotFoundException("Nu exista doctor");
        }
        return this.doctorRepo.findById(id) ;
    }
    public void delDoctor(int id) {
        this.doctorRepo.deleteById(id);
    }
}
