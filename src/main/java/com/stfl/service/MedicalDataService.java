package com.stfl.service;

import com.stfl.dao.ApplicationUserRepository;
import com.stfl.dao.MedicalDataRepository;
import com.stfl.dto.MedicalDataDTO;
import com.stfl.exception.MedicalDataNotFoundException;
import com.stfl.model.MedicalData;
import com.stfl.service.convertation.medicalData.ConvertationMedicalData;
import com.stfl.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicalDataService {

    @Autowired
    private MedicalDataRepository medicalDataRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ConvertationMedicalData convert;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    public MedicalDataDTO findById(Long id) {
        MedicalData medicalData = medicalDataRepository.findById(id).orElseThrow(() ->
                new MedicalDataNotFoundException());
        return new MedicalDataDTO(medicalData);
    }

    @Transactional
    public MedicalDataDTO saveMedicalData(MedicalDataDTO medicalDataDTO) {
        ApplicationUser user = securityService.getUserFromSession();
        return proccesOfSaving(medicalDataDTO, user);
    }

    private MedicalDataDTO proccesOfSaving(MedicalDataDTO medicalDataDTO, ApplicationUser user) {
        user.getUserProfile().setMedicalData(convert.toModel(medicalDataDTO));
        ApplicationUser userRes = applicationUserRepository.saveAndFlush(user);
        return new MedicalDataDTO(userRes.getUserProfile().getMedicalData());
    }
}
