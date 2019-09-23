package com.stfl.controller;

import com.stfl.dto.AddressDto;
import com.stfl.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "/api", description = "operation with address")
@RequestMapping("/users/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "creating Address of current user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created Address"),
            @ApiResponse(code = 403, message = "Address already have been created")
    })
    @PostMapping
    public ResponseEntity<CustomResponse> postAddress(@RequestBody AddressDto addressDto) {
        CustomResponse<AddressDto> response = new CustomResponse<>();
        response.responseWithCreated(addressService.saveAddress(addressDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @ApiOperation(value = "view Address by id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved Address"),
//            @ApiResponse(code = 404, message = "Address was not found")
//    }

//    @GetMapping
//    public ResponseEntity<CustomResponse> getAddress(@RequestParam(value = "id") Long id) {
//        CustomResponse<AddressDto> response = new CustomResponse<>();
//        response.responseWithOK(addressService.findById(id));
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }
}
