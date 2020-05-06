package com.elayaraja.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GetDoctorResponse {

    @JsonProperty("doctors")
    private List<Doctor> doctors = new ArrayList<Doctor>();

    public GetDoctorResponse doctors(List<Doctor> doctors){
        this.doctors = doctors;
        return this;
    }

    public GetDoctorResponse addDoctor(Doctor doctor){
        this.doctors.add(doctor);
        return this;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
