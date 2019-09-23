package com.stfl.service;

import com.stfl.dao.ApplicationUserRepository;
import com.stfl.dao.HospitalDispatcherRepository;
import com.stfl.dao.HospitalRepository;
import com.stfl.dto.HospitalDispatcherDto;
import com.stfl.exception.ApplicationException;
import com.stfl.exception.ApplicationUserNotFoundException;
import com.stfl.exception.HospitalDispatcherNotFoundException;
import com.stfl.exception.HospitalNotFoundException;
import com.stfl.model.Hospital;
import com.stfl.model.HospitalDispatcher;
import com.stfl.service.convertation.hospitalDispatcher.ConvertationDispatcher;
import com.stfl.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HospitalDispatcherService {

    @Autowired
    private HospitalDispatcherRepository dispatcherRepo;

    @Autowired
    private ApplicationUserRepository userRepo;

    @Autowired
    private HospitalRepository hospitalRepo;

    @Autowired
    private ConvertationDispatcher convert;

    public HospitalDispatcherDto findById(Long id) {
        return  new HospitalDispatcherDto(dispatcherRepo
                .findHospitalDispatcherById(id)
                .orElseThrow(() -> new HospitalDispatcherNotFoundException()));
    }

    @Transactional
    public HospitalDispatcherDto saveDispatcher(HospitalDispatcherDto dispatcherDto, String username) {
        ApplicationUser user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ApplicationUserNotFoundException());

        if(user.getHospitalDispatcher() == null) {
            return proccesOfSaving(dispatcherDto, user);
        } else {
            throw new ApplicationException("Hospital Dispatcher already have been created.");
        }
    }

    @Transactional
    public HospitalDispatcherDto updateDispatcher(HospitalDispatcherDto dispatcherDto, String username) {
        ApplicationUser user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ApplicationUserNotFoundException());

        if(user.getHospitalDispatcher() != null) {
            return proccesOfSaving(dispatcherDto, user);
        } else {
            throw new HospitalDispatcherNotFoundException();
            }
        }

        @Transactional
        public HospitalDispatcherDto addHospitalToDispatcher(Long hospitalId, Long dispatcherId) {

        HospitalDispatcher dispatcher = dispatcherRepo
                .findHospitalDispatcherById(dispatcherId)
                .orElseThrow(() -> new HospitalDispatcherNotFoundException());

        Hospital hospital = hospitalRepo.findById(hospitalId)
                .orElseThrow( () -> new HospitalNotFoundException());
        dispatcher.setHospital(hospital);

        return new HospitalDispatcherDto(dispatcherRepo.saveAndFlush(dispatcher)
        );
    }

    private HospitalDispatcherDto proccesOfSaving(HospitalDispatcherDto dispatcherDto,
                                               ApplicationUser user) {
        user.setHospitalDispatcher(convert.toModel(dispatcherDto));
        ApplicationUser userRes = userRepo.saveAndFlush(user);
        return new HospitalDispatcherDto(userRes.getHospitalDispatcher());
    }

}
