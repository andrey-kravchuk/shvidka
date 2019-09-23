package com.stfl.service;

import com.stfl.dao.HospitalRepository;
import com.stfl.exception.ApplicationException;
import com.stfl.exception.HospitalDispatcherNotFoundException;
import com.stfl.model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepo;

    public List<Hospital> findAllHospitals() {
        List<Hospital> hospitals = hospitalRepo.findAll();
        return hospitals;
    }

    public Hospital saveHospital(Hospital hospital) {
        if (hospital.getId() == null) {
            return hospitalRepo.save(hospital);
        } else {
            throw new ApplicationException("Hospital has already been created.");
        }
    }

    public Hospital updateHospital(Hospital hospital) {
        if (hospital.getId() != null) {
            return hospitalRepo.save(hospital);
        } else {
            throw new HospitalDispatcherNotFoundException("Hospital hasn't been created yet.");
        }
    }
}
