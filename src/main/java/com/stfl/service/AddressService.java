package com.stfl.service;

import com.stfl.dao.AddressRepository;
import com.stfl.dao.ApplicationUserRepository;
import com.stfl.dto.AddressDto;
import com.stfl.exception.AddressNotFoundException;
import com.stfl.model.Address;
import com.stfl.service.convertation.address.ConvertationAddress;
import com.stfl.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private ConvertationAddress convert;

    public AddressDto findById(Long id) {
        Address medicalData = addressRepository.findById(id).orElseThrow(() ->
                new AddressNotFoundException());
        return new AddressDto(medicalData);
    }

    @Transactional
    public AddressDto saveAddress(AddressDto addressDto) {
        ApplicationUser user = securityService.getUserFromSession();
        return proccesOfSaving(addressDto,user);

    }

    public AddressDto proccesOfSaving (AddressDto addressDto, ApplicationUser user){
        user.getUserProfile().setAddress(convert.toModel(addressDto));
        ApplicationUser userRes = applicationUserRepository.saveAndFlush(user);
        return new AddressDto(userRes.getUserProfile().getAddress());
    }

}
