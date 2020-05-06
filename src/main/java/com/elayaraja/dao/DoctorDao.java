package com.elayaraja.dao;

import com.elayaraja.entity.Doctor;

import java.util.Collection;

public interface DoctorDao {

    Collection<Doctor> getAllDoctors();

    Doctor getDoctor(String id);

    Doctor removeDoctor(String id);

    Doctor updateDoctor(Doctor doctor);

    Doctor addDoctor(Doctor doctor);
}
