package com.stfl.controller;

import com.stfl.dto.UserProfileDto;
import com.stfl.model.Hospital;
import com.stfl.service.UserProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "/api", description = "operation with profiles")
@RequestMapping("/users/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @ApiOperation(value = "view UserProfile by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved UserProfile"),
            @ApiResponse(code = 404, message = "UserProfile was not found")
    })
    @GetMapping
    public ResponseEntity<CustomResponse> getProfile(@RequestParam(value = "id") Long id) {
        CustomResponse<UserProfileDto> response = new CustomResponse<>();
        response.responseWithOK(userProfileService.findById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "creating UserProfile of current user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created UserProfile"),
            @ApiResponse(code = 403, message = "UserProfile already have been created")
    })
    @PostMapping
    public ResponseEntity<CustomResponse> postProfile(@RequestBody UserProfileDto userProfileDto) {
        CustomResponse<UserProfileDto> response = new CustomResponse<>();
        response.responseWithCreated(userProfileService.saveProfile(userProfileDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "update UserProfile")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated UserProfile"),
            @ApiResponse(code = 404, message = "UserProfile was not found")
    })
    @PutMapping
    public ResponseEntity<CustomResponse> putProfile(@RequestBody UserProfileDto userProfileDto) {
        CustomResponse<UserProfileDto> response = new CustomResponse<>();
        response.responseWithOK(userProfileService.updateProfile(userProfileDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/sign_contract")
    public ResponseEntity<CustomResponse> signContractWithHospital(@RequestParam(value = "hospitalId") Long hospitalId) {
        CustomResponse<UserProfileDto> response = new CustomResponse<>();
        response.responseWithOK(userProfileService.signContractWithHospital(hospitalId));
        response.addMessage("sign contract successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

