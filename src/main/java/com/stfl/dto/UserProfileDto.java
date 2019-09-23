package com.stfl.dto;

import com.stfl.model.Address;
import com.stfl.model.Hospital;
import com.stfl.model.MedicalData;
import com.stfl.model.UserProfile;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserProfileDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String sex;
    private LocalDate birthDate;
    private String phone;
//    private Long medicalData_id;
    private MedicalData medicalData;
//    private Long address_id;
    private Address address;
    private List<Long> userGroupsIdList = new ArrayList<>();
    private byte[] photo;
    private int age;
    private Hospital contractWith;

    public void addUserGroupIdList(Long id) {
        userGroupsIdList.add(id);
    }

    public UserProfileDto(UserProfile userProfile) {
        this.id = userProfile.getId();
        this.firstName = userProfile.getFirstName();
        this.lastName = userProfile.getLastName();
        this.patronymic = userProfile.getPatronymic();
        this.sex = userProfile.getSex();
        this.birthDate = userProfile.getBirthDate();
        this.phone = userProfile.getPhone();
        this.photo = userProfile.getPhoto();
        this.medicalData = userProfile.getMedicalData();
        this.contractWith = userProfile.getContractWith();
//        if (userProfile.getMedicalData() != null) {
//            this.setMedicalData_id(userProfile.getMedicalData().getId());
//        } else {
//            this.setMedicalData_id(0L);
//        }
        this.address = userProfile.getAddress();
        if (!userProfile.getGroups().isEmpty()) {
            userProfile.getGroups().forEach(UserGroup ->
                    this.addUserGroupIdList(UserGroup.getId())
            );
        }
//        if (userProfile.getAddress() != null){
//            this.setAddress_id(userProfile.getAddress().getId());
//        } else {
//            this.setAddress_id(0L);
//        }
        this.age =LocalDate.now().getYear() - userProfile.getBirthDate().getYear();
    }
}
