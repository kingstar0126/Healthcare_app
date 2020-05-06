package com.elayaraja.service;

import com.elayaraja.entity.Doctor;
import com.elayaraja.entity.GetDoctorResponse;

import java.util.Optional;

public interface DoctorService {

    public Doctor addDoctor(Doctor doctor);

    public GetDoctorResponse getAllDoctors();

    public Optional<Doctor> findDoctorById(String id);

    public Doctor update(Doctor doctor);

    public Optional<Doctor> deleteDoctorById(String id);
}
