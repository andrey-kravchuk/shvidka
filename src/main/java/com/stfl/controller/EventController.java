package com.stfl.controller;

import com.stfl.dto.EventDto;
import com.stfl.model.EventInfo;
import com.stfl.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    //this methods is only for Dispatcher Role
    @GetMapping
    public ResponseEntity<CustomResponse> getEvent(@RequestParam(value = "id") Long id) {
        CustomResponse<EventDto> response = new CustomResponse<>();
        response.responseWithOK(eventService.findEvent(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<CustomResponse> getAllEvents() {
        CustomResponse<List<EventDto>> response = new CustomResponse<>();
        response.responseWithOK(eventService.findAllEvents());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<CustomResponse> getActiveEvents() {
        CustomResponse<List<EventDto>> response = new CustomResponse<>();
        response.responseWithOK(eventService.findActiveEvents());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/accepted")
    public ResponseEntity<CustomResponse> getAcceptedEvents() {
        CustomResponse<List<EventDto>> response = new CustomResponse<>();
        response.responseWithOK(eventService.findAcceptedEvents());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/closed")
    public ResponseEntity<CustomResponse> getClosedEvents() {
        CustomResponse<List<EventDto>> response = new CustomResponse<>();
        response.responseWithOK(eventService.findClosedEvents());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/canceled")
    public ResponseEntity<CustomResponse> getCanceledEvents() {
        CustomResponse<List<EventDto>> response = new CustomResponse<>();
        response.responseWithOK(eventService.findCanceledEvents());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomResponse> postEvent(@RequestParam(value = "patientId") Long patientId,
                                                    @RequestParam(value = "hospitalId") Long hospitalId,
                                                    @RequestParam(value = "otherAddress") boolean otherAddress) {
        CustomResponse response = new CustomResponse();
        response.responseWithCreated(eventService.createEvent(patientId, hospitalId, otherAddress));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/accept")
    public ResponseEntity<CustomResponse> putAcceptEvent(@RequestParam(value = "id") Long id) {
        CustomResponse<EventDto> response = new CustomResponse<>();
        response.responseWithOK(eventService.acceptEvent(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //this methods is only for Dispatcher Role
    @PutMapping("/close")
    public ResponseEntity<CustomResponse> putCloseEvent(@RequestBody EventInfo eventInfo,
                                                        @RequestParam(value = "eventId") Long id) {
        CustomResponse<EventDto> response = new CustomResponse();
        response.responseWithOK(eventService.closeEvent(id, eventInfo));
        response.addMessage("Event closed successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/cancel")
    public ResponseEntity<CustomResponse> putCancelEvent(@RequestParam(value = "eventId") Long id,
                                                         @RequestParam(value = "noteOfCall") String note) {
        CustomResponse<EventDto> response = new CustomResponse<>();
        response.responseWithOK(eventService.cancelEvent(id, note));
        response.addMessage("Event canceled successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
