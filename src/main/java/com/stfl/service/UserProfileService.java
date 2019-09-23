package com.stfl.service;

import com.stfl.dao.ApplicationUserRepository;
import com.stfl.dao.HospitalRepository;
import com.stfl.dao.UserProfileRepository;
import com.stfl.dto.UserProfileDto;
import com.stfl.exception.ApplicationException;
import com.stfl.exception.ApplicationUserNotFoundException;
import com.stfl.exception.HospitalNotFoundException;
import com.stfl.exception.UserProfileNotFoundException;
import com.stfl.model.Hospital;
import com.stfl.model.UserProfile;
import com.stfl.service.convertation.userProfile.ConvertationUserProfile;
import com.stfl.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepo;

    @Autowired
    private ApplicationUserRepository userRepo;

    @Autowired
    private HospitalRepository hospitalRepo;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ConvertationUserProfile convert;

    public UserProfileDto findById(Long id) {
        UserProfile userProfile = userProfileRepo.findUserProfileById(id).orElseThrow(() ->
                new UserProfileNotFoundException());
        return new UserProfileDto(userProfile);
    }

    @Transactional
    public UserProfileDto saveProfile(UserProfileDto userProfileDto) {
        ApplicationUser user = securityService.getUserFromSession();
        userProfileDto.setPhone(user.getUsername());
        Long hospGovernmentId = 1L;
        userProfileDto.setContractWith(hospitalRepo
                .findById(hospGovernmentId)
                .orElseThrow(() -> new HospitalNotFoundException()));
        if (user.getUserProfile() == null) {
            return proccesOfSaving(userProfileDto, user);
        } else {
            throw new ApplicationException("UserProfile already have been created.");
        }
    }

    @Transactional
    public UserProfileDto updateProfile(UserProfileDto userProfileDto) {
        ApplicationUser user = securityService.getUserFromSession();
        if (user.getUserProfile() != null && userProfileDto.getId() != null) {
            userProfileDto.setPhone(user.getUsername());
            return proccesOfSaving(userProfileDto, user);
        } else {
            throw new UserProfileNotFoundException();
        }
    }

    private UserProfileDto proccesOfSaving(UserProfileDto userProfileDto, ApplicationUser user) {
        user.setUserProfile(convert.toModel(userProfileDto));
        ApplicationUser userRes = userRepo.saveAndFlush(user);
        return new UserProfileDto(userRes.getUserProfile());
    }

    @Transactional
    public UserProfileDto signContractWithHospital(Long hospitalId) {
        ApplicationUser user = securityService.getUserFromSession();
        Hospital hospital = hospitalRepo.findById(hospitalId)
                .orElseThrow(() -> new HospitalNotFoundException());
        user.getUserProfile().setContractWith(hospital);
        userRepo.saveAndFlush(user);
        return new UserProfileDto(userRepo
                .findByUsername(user.getUsername())
                .orElseThrow(() -> new ApplicationUserNotFoundException())
                .getUserProfile());
    }
}
