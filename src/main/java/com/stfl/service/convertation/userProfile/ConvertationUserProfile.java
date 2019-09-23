package com.stfl.service.convertation.userProfile;

import com.stfl.dao.MedicalDataRepository;
import com.stfl.dao.UserGroupRepository;
import com.stfl.dto.UserProfileDto;
import com.stfl.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertationUserProfile {

    @Autowired
    private MedicalDataRepository medicalDataRepo;

    @Autowired
    private UserGroupRepository userGroupRepo;

//    @Autowired
//    private ModelMapper mapper;


    public UserProfile toModel(UserProfileDto dto) {
       UserProfile model = new UserProfile();
       model.setId(dto.getId());
       model.setFirstName(dto.getFirstName());
       model.setLastName(dto.getLastName());
       model.setPatronymic(dto.getPatronymic());
       model.setSex(dto.getSex());
       model.setPhone(dto.getPhone());
       model.setBirthDate(dto.getBirthDate());
       model.setPhoto(dto.getPhoto());
       model.setMedicalData(dto.getMedicalData());
       model.setAddress(dto.getAddress());
       model.setContractWith(dto.getContractWith());
//        if (dto.getMedicalData_id() != null && dto.getMedicalData_id() != 0L) {
//            model.setMedicalData(medicalDataRepo.findById(dto.getMedicalData_id()).orElse(null));
//        }
        if (!dto.getUserGroupsIdList().isEmpty()) {
            dto.getUserGroupsIdList().forEach(id ->
                    model.addUserGroupList(userGroupRepo.findById(id).orElse(null))
            );
        }
        return model;
    }

//    public UserProfileDto toDto(UserProfile model) {
//        UserProfileDto dto = mapper.map(model, UserProfileDto.class);
//        if (model.getMedicalData() != null) {
//            dto.setMedicalData_id(model.getMedicalData().getId());
//        } else {
//            dto.setMedicalData_id(EMPTY);
//        }
//        if (!model.getUserGroupsList().isEmpty()) {
//            model.getUserGroupsList().forEach(UserGroup ->
//                    dto.addUserGroupIdList(UserGroup.getId())
//            );
//        }
//        return dto;
//    }
}
