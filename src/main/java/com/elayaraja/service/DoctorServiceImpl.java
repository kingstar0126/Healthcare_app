package com.elayaraja.service;

import com.elayaraja.dao.DoctorRepository;
import com.elayaraja.entity.Doctor;
import com.elayaraja.entity.GetDoctorResponse;
import com.elayaraja.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        Optional<Doctor> doctorResult = doctorRepository.findById(doctor.getId());
        if(doctorResult.isPresent()){
            throw new ApiRequestException(String.format("Doctor with id %s already present!",doctor.getId()));
        }else{
            return doctorRepository.save(doctor);
        }
    }

    @Override
    public GetDoctorResponse getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        GetDoctorResponse getDoctorResponse = new GetDoctorResponse();
        getDoctorResponse.setDoctors(doctors);
        return getDoctorResponse;
    }

    @Override
    public Optional<Doctor> findDoctorById(String id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor update(Doctor doctor) {

        Optional<Doctor> doctorResult = doctorRepository.findById(doctor.getId());
        if(doctorResult.isPresent()){
            Doctor d =
                    new Doctor(
                            doctor.getId(),
                            doctor.getName(),
                            doctor.getAge(),
                            doctor.getGender(),
                            doctor.getEmail(),
                            doctor.getAadhaar(),
                            doctor.getMobile(),
                            doctor.getAddress(),
                            doctor.getAreaCode(),
                            doctor.getHospital(),
                            doctor.getSpeciality()
                    );
            doctorRepository.save(d);
        }else{
            throw new ApiRequestException(String.format("Doctor with doctor %s not found!", doctor.getId()));
        }
        return doctor;
    }

    @Override
    public Optional<Doctor> deleteDoctorById(String id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()){
            doctorRepository.deleteById(id);
        }else{
            throw new ApiRequestException(String.format("Doctor with doctor %s not found!",id));
        }
        return doctor;
    }

    /*public Collection<Doctor> getAllDoctors(){
        return doctorDao.getAllDoctors();
    }

    public Doctor getDoctor(int id){
        return doctorDao.getDoctor(id);
    }

    public Doctor removeDoctorById(int id){
        return doctorDao.removeDoctor(id);
    }

    public Doctor updateDoctor(Doctor doctor){
        return doctorDao.updateDoctor(doctor);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorDao.addDoctor(doctor);
    }*/
}
