package com.stfl.controller;

import com.stfl.dto.UserGroupDto;
import com.stfl.dto.UserProfileDto;
import com.stfl.model.UserGroup;
import com.stfl.model.UserProfile;
import com.stfl.service.UserGroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "/api", description = "operation with group")
@RequestMapping("/users/group")
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;


    @PostMapping("/add_group")
    public ResponseEntity<CustomResponse> postGroup(@RequestBody UserGroupDto userGroupDto){
        CustomResponse<UserGroupDto> response = new CustomResponse<>();
        response.responseWithCreated(userGroupService.saveGroup(userGroupDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/add_profile")
    public ResponseEntity<CustomResponse> addProfile(@RequestParam Long profileId, Long groupId ){
        CustomResponse<UserGroupDto> response = new CustomResponse<>();
        response.responseWithOK(userGroupService.addProfileInGroup(profileId, groupId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get_users")
    public ResponseEntity<CustomResponse> getUsers(@RequestParam Long groupId) {
        CustomResponse<UserGroup> response = new CustomResponse<>();
        response.responseWithCreated(userGroupService.findById(groupId));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
