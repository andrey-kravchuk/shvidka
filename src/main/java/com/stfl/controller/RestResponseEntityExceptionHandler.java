package com.stfl.controller;

import com.stfl.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class, SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<CustomResponse> handleResponseValidationException(Exception exception){
        HttpStatus code = HttpStatus.BAD_REQUEST;

        CustomResponse response = new CustomResponse();
        response.setStatusCode(code.value());
        ConstraintViolationException newExc = (ConstraintViolationException) exception;

        List errors = new ArrayList(newExc
                .getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList()));
        response.setMessages(errors);
        return new ResponseEntity<>(response, code);
    }

    @ExceptionHandler({ApplicationUserNotFoundException.class, ApplicationUserGroupNotFoundException.class,
            HospitalDispatcherNotFoundException.class, HospitalNotFoundException.class, EventNotFoundException.class,
            MedicalDataNotFoundException.class, UserProfileNotFoundException.class, AddressNotFoundException.class})
    public ResponseEntity<CustomResponse> handleResponseNotFoundExceptions(Exception exception) {
        ApplicationException newExc = (ApplicationException) exception;
        HttpStatus code = HttpStatus.NOT_FOUND;
        CustomResponse response = new CustomResponse();
        response.setStatusCode(code.value());
        response.addMessage(newExc.getMessage());
        return new ResponseEntity<>(response, code);
    }

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<CustomResponse> handleResponseApplicationException(Exception exception) {
        ApplicationException newExc = (ApplicationException) exception;
        HttpStatus code = HttpStatus.FORBIDDEN;
        CustomResponse response = new CustomResponse();
        response.setStatusCode(code.value());
        response.addMessage(newExc.getMessage());
        return new ResponseEntity<>(response, code);
    }
}
