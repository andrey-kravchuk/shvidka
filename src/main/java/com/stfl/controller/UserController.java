package com.stfl.controller;

import com.stfl.dao.ApplicationUserRepository;
import com.stfl.dto.UserDto;
import com.stfl.service.ApplicationUserService;
import com.stfl.service.SecurityService;
import com.stfl.user.ApplicationUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "/api", description = "Operation with user")
@RequestMapping("/users")
public class UserController {

    @Autowired
    SecurityService securityService;

    @Autowired
    ApplicationUserService applicationUserService;

    private ApplicationUserRepository applicationUserRepository;

    public UserController(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @ApiResponse(code = 201, message = "Successfully created")
    @PostMapping("/sign_up")
    public ResponseEntity<CustomResponse> signUp(@RequestBody ApplicationUser user) {
        CustomResponse<UserDto> response = new CustomResponse<>();
        response.responseWithCreated(new UserDto(securityService.saveUser(user)));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiResponse(code = 200, message = "Successfully operation")
    @GetMapping("/get_user")
    public ResponseEntity<CustomResponse> getUser() {
        CustomResponse<UserDto> response = new CustomResponse<>();
        response.responseWithOK(new UserDto(securityService.getUserFromSession()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all_users")
    public ResponseEntity<CustomResponse> getAllUsers() {
        CustomResponse<List<UserDto>> response = new CustomResponse<>();
        response.responseWithOK(applicationUserService.getAllUsers());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
