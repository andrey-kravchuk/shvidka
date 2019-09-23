package com.stfl.service.convertation.userGroup;

import com.stfl.dao.UserProfileRepository;
import com.stfl.dto.UserGroupDto;
import com.stfl.exception.ApplicationUserGroupNotFoundException;
import com.stfl.model.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertationGroup {

    @Autowired
    private UserProfileRepository profileRepo;

    public UserGroup toModel(UserGroupDto userGroupDto) {
        UserGroup model = new UserGroup();
        model.setId(userGroupDto.getId());
        model.setName(userGroupDto.getName());
        model.setOwner(profileRepo
                .findById(userGroupDto.getOwnerId())
                .orElseThrow(() -> new ApplicationUserGroupNotFoundException()));
        if (!userGroupDto.getUserProfiles().isEmpty()) {
            userGroupDto.getUserProfiles().forEach(id ->
                    model.getUserProfiles().add(profileRepo.findById(id).orElse(null))
            );
        }
        return model;
    }
}
