package com.stfl.service;

import com.stfl.dao.ApplicationUserRepository;
import com.stfl.dao.UserGroupRepository;
import com.stfl.dao.UserProfileRepository;
import com.stfl.dto.UserGroupDto;
import com.stfl.dto.UserProfileDto;
import com.stfl.exception.ApplicationUserGroupNotFoundException;
import com.stfl.exception.UserProfileNotFoundException;
import com.stfl.model.UserGroup;
import com.stfl.model.UserProfile;
import com.stfl.service.convertation.userGroup.ConvertationGroup;
import com.stfl.service.convertation.userProfile.ConvertationUserProfile;
import com.stfl.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Severyn Zlochovksy
 *         created at 20.03.2019
 */
@Service
public class UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private ApplicationUserRepository userRepo;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ConvertationGroup convert;

    @Autowired
    private ConvertationUserProfile convertProfile;

    @Autowired
    private UserProfileRepository userProfileRepository;


    public UserGroup findById(Long id) {
        return userGroupRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationUserGroupNotFoundException());
    }

    @Transactional
    public UserGroupDto saveGroup(UserGroupDto userGroupDto) {
        ApplicationUser user = securityService.getUserFromSession();
        userGroupDto.setOwnerId(user.getUserProfile().getId());
        UserGroup group = convert.toModel(userGroupDto);

        user.getUserProfile().addUserGroupList(group);
        userRepo.saveAndFlush(user);

        return new UserGroupDto(userGroupRepository
                .findByName(userGroupDto.getName())
                .orElseThrow(() -> new ApplicationUserGroupNotFoundException()));
    }

    @Transactional
    public UserGroupDto addProfileInGroup(Long userProfileId, Long groupId) {
        UserGroup group = (userGroupRepository
                .findById(groupId)
                .orElseThrow(() -> new ApplicationUserGroupNotFoundException()));
        UserProfile userProfile = (userProfileRepository
                .findById(userProfileId)
                .orElseThrow(() -> new UserProfileNotFoundException()));
        group.getUserProfiles().add(userProfile);
        userGroupRepository.saveAndFlush(group);
        return new UserGroupDto(userGroupRepository.findById(groupId)
                .orElseThrow(() -> new ApplicationUserGroupNotFoundException()));
    }

}
