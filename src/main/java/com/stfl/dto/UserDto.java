package com.stfl.dto;

import com.stfl.model.HospitalDispatcher;
import com.stfl.model.UserProfile;
import com.stfl.user.ApplicationUser;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String username;
    private String email;
//    private Long userProfileId;
    private UserProfile userProfile;
//    private Long hospitalDispatcherId;
    private HospitalDispatcher hospitalDispatcher;

    public UserDto(ApplicationUser applicationUser) {
        this.username = applicationUser.getUsername();
        this.email = applicationUser.getEmail();
//        if (applicationUser.getUserProfile() != null) {
//            this.userProfileId = applicationUser.getUserProfile().getId();
//        } else {
//            this.userProfileId = 0L;
//        }
        this.userProfile = applicationUser.getUserProfile();
//        if (applicationUser.getHospitalDispatcher() != null) {
//            this.hospitalDispatcherId = applicationUser.getHospitalDispatcher().getId();
//        } else {
//            this.hospitalDispatcherId = 0L;
//        }
        this.hospitalDispatcher = applicationUser.getHospitalDispatcher();
    }
}
