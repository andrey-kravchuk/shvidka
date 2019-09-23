package com.stfl.controller;

import com.stfl.model.Hospital;
import com.stfl.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Api(value = "/api", description = "operation with Hospital")
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @ApiOperation(value = "view all hospital which database have")
    @ApiResponse(code = 200, message = "Successfully retrieved list of Hospital")
    @GetMapping("/get_all")
    public ResponseEntity<CustomResponse> getAllHospital() {
        CustomResponse<List<Hospital>> response = new CustomResponse<>();
        response.responseWithOK(hospitalService.findAllHospitals());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "create Hospital (this controller is for Admin Role only")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created Hospital"),
            @ApiResponse(code = 403, message = "Hospital already have been created")
    })
    //this POST method have access only for Admin Role!!
    @PostMapping
    public ResponseEntity<CustomResponse> postHospital(@RequestBody Hospital hospital) {
        CustomResponse<Hospital> response = new CustomResponse<>();
        response.responseWithCreated(hospitalService.saveHospital(hospital));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "update Hospital (this controller is for Admin Role only")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully updated Hospital"),
            @ApiResponse(code = 403, message = "Hospital was not found")
    })
    //this PUT method have access only for Admin Role!!
    @PutMapping
    public ResponseEntity<CustomResponse> putHospital(@RequestBody Hospital hospital) {
        CustomResponse<Hospital> response = new CustomResponse<>();
        response.responseWithOK(hospitalService.updateHospital(hospital));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
