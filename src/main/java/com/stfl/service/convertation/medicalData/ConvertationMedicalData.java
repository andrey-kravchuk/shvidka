package com.stfl.service.convertation.medicalData;

import com.stfl.dao.UserProfileRepository;
import com.stfl.dto.MedicalDataDTO;
import com.stfl.model.MedicalData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ConvertationMedicalData {

    @Autowired
    private UserProfileRepository userProfileRepo;

//    @Autowired
//    private ModelMapper modelMapper;

    public MedicalData toModel(MedicalDataDTO dto) {
        MedicalData model = new MedicalData();
        model.setId(dto.getId());
        model.setHeight(dto.getHeight());
        model.setWeight(dto.getWeight());
        model.setAllergies(dto.getAllergies());
        model.setChronicDiseases(dto.getChronicDiseases());
        model.setMedications(dto.getMedications());
        return model;
    }

//    public MedicalDataDTO toDto(MedicalData model) {
//        MedicalDataDTO dto = modelMapper.map(model, MedicalDataDTO.class);
//        return dto;
//    }
}
