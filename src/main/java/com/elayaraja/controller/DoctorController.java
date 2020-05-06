package com.elayaraja.controller;

import com.elayaraja.entity.Doctor;
import com.elayaraja.entity.GetDoctorResponse;
import com.elayaraja.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public GetDoctorResponse getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Greeting from Spring Boot!";
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable String id){
        return doctorService.findDoctorById(id);
    }

    @PostMapping()
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public Optional<Doctor> removeDoctor(@PathVariable String id){
        return doctorService.deleteDoctorById(id);
    }

    @PutMapping()
    public Doctor updateDoctor(@RequestBody Doctor doctor){
        return doctorService.update(doctor);
    }
}
