package com.elayaraja.dao;

import com.elayaraja.entity.Doctor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DoctorDaoImpl implements DoctorDao {

    private static Map<String, Doctor> doctors;

    static {
        doctors = new HashMap<String, Doctor>(){
            {
                put("1", new Doctor("01", "Thulsi", "31", "Female", "thulsi@gmail.com", "1239245214324", "9241302342", "Bangalore", "560059", "Bangalore", new String[]{"Gynecologist"}));            }
        };
    }

    @Override
    public Collection<Doctor> getAllDoctors(){
        return this.doctors.values();
    }

    @Override
    public Doctor getDoctor(String id){
        return this.doctors.get(id);
    }

    @Override
    public Doctor removeDoctor(String id){
        Doctor doctor = getDoctor(id);
        this.doctors.remove(id);
        return doctor;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        Doctor d = doctors.get(doctor.getId());
        d.setName(doctor.getName());
        doctors.put(d.getId(), d);
        return d;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        Doctor d = doctors.get(doctor.getId());
        if(d==null) {
            doctors.put(doctor.getId(), doctor);
            return doctor;
        }
        else
            return d;
    }
}
