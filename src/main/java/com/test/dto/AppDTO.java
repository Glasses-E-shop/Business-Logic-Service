package com.test.dto;

import com.test.entities.Doctor;
import lombok.Data;

import java.util.Date;
@Data
public class AppDTO {
    private Date date;
    private int id_doctor;
}
