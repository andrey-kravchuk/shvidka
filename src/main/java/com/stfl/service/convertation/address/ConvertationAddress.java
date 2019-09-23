package com.stfl.service.convertation.address;

import com.stfl.dao.UserProfileRepository;
import com.stfl.dto.AddressDto;
import com.stfl.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertationAddress {

    @Autowired
    private UserProfileRepository userProfileRepo;

    public Address toModel(AddressDto dto) {
        Address model = new Address();
        model.setId(dto.getId());
        model.setCountry(dto.getCountry());
        model.setCity(dto.getCity());
        model.setState(dto.getState());
        model.setStreet(dto.getStreet());
        model.setBuild(dto.getBuild());
        model.setCorps(dto.getCorps());
        model.setApartment(dto.getApartment());
        model.setEntranceCode(dto.getEntranceCode());
        model.setFloor(dto.getFloor());
        model.setTrack(dto.isTrack());

//        if (dto.getUserProfileId() != null && dto.getUserProfileId() != 0L) {
//            model.setUserProfile(userProfileRepo.findUserProfileById(dto.getUserProfileId()).orElse(null));
//        }
        return model;
    }
}
