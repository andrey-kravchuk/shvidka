package com.stfl.dto;

import com.stfl.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EventDto {

    private Long id;
    private UserProfile caller;
    private UserProfile patient;
    private Hospital hospital;
    private Address address;
    private EventInfo eventInfo;
    private String status;
    private String noteOfCall;
    private String callerEmail;
    private LocalDateTime dateTime;

    public EventDto (Event event) {
        this.id = event.getId();
        this.caller = event.getCaller();
        this.patient = event.getPatient();
        this.hospital = event.getHospital();
        this.address = event.getAddress();
        this.eventInfo = event.getEventInfo();
        this.status = event.getStatus();
        this.noteOfCall = event.getNoteOfCall();
        this.callerEmail = event.getCallerEmail();
        this.dateTime = event.getDateTime();
    }
}
