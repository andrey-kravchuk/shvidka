package com.stfl.dto;

import com.stfl.model.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    private Long id;
    private String country;
    private String city;
    private String state;
    private String street;
    private String build;
    private String corps;
    private String apartment;
    private String floor;
    private String entranceCode;
    private Long userProfileId;
    private boolean track;

    public AddressDto(Address address) {
        this.id = address.getId();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.state = address.getState();
        this.street = address.getStreet();
        this.build = address.getBuild();
        this.corps = address.getCorps();
        this.apartment = address.getApartment();
        this.floor = address.getFloor();
        this.entranceCode = address.getEntranceCode();
//        if (address.getUserProfile() != null){
//            this.setUserProfileId(address.getUserProfile().getId());
//        } else {
//            this.setUserProfileId(0L);
//        }
        this.track = address.isTrack();
    }
}
