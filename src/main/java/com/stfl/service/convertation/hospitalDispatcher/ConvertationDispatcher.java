package com.stfl.service.convertation.hospitalDispatcher;

import com.stfl.dao.HospitalRepository;
import com.stfl.dto.HospitalDispatcherDto;
import com.stfl.model.HospitalDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertationDispatcher {

    @Autowired
    private HospitalRepository hospitalRepo;


    public HospitalDispatcher toModel(HospitalDispatcherDto dto) {
        HospitalDispatcher model = new HospitalDispatcher();
        model.setId(dto.getId());
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setPatronymic(dto.getPatronymic());
        if(dto.getHospitalId() != null && dto.getHospitalId() != 0L) {
            model.setHospital(hospitalRepo.findById(dto.getHospitalId()).orElse(null));
        }
        return model;
    }
}
