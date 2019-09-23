package com.stfl.controller;

import com.stfl.dto.MedicalDataDTO;
import com.stfl.service.MedicalDataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "/api", description = "operation with medical data")
@RequestMapping("/users/medicalData")
public class MedicalDataController {

    @Autowired
    MedicalDataService medicalDataService;

//    @GetMapping
//    public ResponseEntity<CustomResponse> getMedicalData(@RequestParam(value = "id") Long id) {
//        CustomResponse<MedicalDataDTO> response = new CustomResponse<>();
//        response.responseWithOK(medicalDataService.findById(id));
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<CustomResponse> postMedicalData(@RequestBody MedicalDataDTO medicalDataDTO) {
        CustomResponse<MedicalDataDTO> response = new CustomResponse<>();
        response.responseWithCreated(medicalDataService.saveMedicalData(medicalDataDTO));
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
