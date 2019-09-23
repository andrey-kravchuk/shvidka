package com.stfl.controller;

import com.stfl.dto.UserDto;
import com.stfl.service.SecurityService;
import com.stfl.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {



    @Autowired
    private SecurityService securityService;

    @PostMapping("/login")
    public void login(@RequestBody ApplicationUser applicationUser){
    }

    /*
    @PostMapping("/successlogin")
    public ResponseEntity<CustomResponse> successLogin() {
        CustomResponse<UserDto> response = new CustomResponse<>();
        response.responseWithOK(new UserDto(securityService.getUserFromSession()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    */
}
