package com.stfl.controller;

import com.stfl.dto.HospitalDispatcherDto;
import com.stfl.service.HospitalDispatcherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "/api", description = "operation with Hospital Dispatcher")
@RequestMapping("/dispatchers")
public class HospitalDispatcherController {

    @Autowired
    private HospitalDispatcherService dispatcherService;

    @ApiOperation(value = "view hospital dispatcher by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of hospital Dispatcher"),
            @ApiResponse(code = 404, message = "hospital Dispatcher was not found")
    })
    @GetMapping
    public ResponseEntity<CustomResponse> getDispatcher(@RequestParam(value = "id") Long id) {
        CustomResponse<HospitalDispatcherDto> response = new CustomResponse<>();
        response.responseWithOK(dispatcherService.findById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "create hospital Dispatcher (this controller is for Admin Role only")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created hospital Dispatcher"),
            @ApiResponse(code = 403, message = "hospital Dispatcher already have been created")
    })

    //This method have access only for Admin Role
    @PostMapping
    public ResponseEntity<CustomResponse> postDispatcher(
            @RequestBody HospitalDispatcherDto hospitalDispatcherDto,
            @RequestParam(value = "username") String username) {
        CustomResponse<HospitalDispatcherDto> response = new CustomResponse<>();
        response.responseWithCreated(dispatcherService.saveDispatcher(hospitalDispatcherDto, username));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "update hospital Dispatcher (this controller is for Admin Role only) ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated hospital Dispatcher"),
            @ApiResponse(code = 403, message = "hospital Dispatcher was not found")
    })

    //this method have access for Admin Role
    @PutMapping
    public ResponseEntity<CustomResponse> putDispatcher(
            @RequestBody HospitalDispatcherDto hospitalDispatcherDto,
            @RequestParam(value = "username") String username) {
        CustomResponse<HospitalDispatcherDto> response = new CustomResponse<>();
        response.responseWithOK(dispatcherService.updateDispatcher(hospitalDispatcherDto, username));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "attach Hospital to hospital Dispatcher (this controller is for Admin Role only) ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully attached to hospitalDispatcher"),
            @ApiResponse(code = 403, message = "hospital Dispatcher was not found")
    })

    //this method have access only for Admin Role
    @PutMapping("/attach_hospital")
    public ResponseEntity<CustomResponse> attachHospital(
            @RequestParam(value = "hospitalId") Long hospitalId,
            @RequestParam(value = "dispatcherId") Long dispatcherId) {
        CustomResponse<HospitalDispatcherDto> response = new CustomResponse<>();
        response.responseWithOK(dispatcherService.addHospitalToDispatcher(hospitalId, dispatcherId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
