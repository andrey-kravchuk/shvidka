package com.stfl.service.convertation.event;

import com.stfl.dto.EventDto;
import com.stfl.model.Event;
import org.springframework.stereotype.Service;

@Service
public class ConvertationEvent {

    public Event toModel(EventDto dto) {
        Event model = new Event();
        model.setId(dto.getId());
        model.setCaller(dto.getCaller());
        model.setPatient(dto.getPatient());
        model.setHospital(dto.getHospital());
        model.setAddress(dto.getAddress());
        model.setEventInfo(dto.getEventInfo());
        model.setStatus(dto.getStatus());
        model.setNoteOfCall(dto.getNoteOfCall());
        model.setCallerEmail(dto.getCallerEmail());
        model.setDateTime(dto.getDateTime());
        return model;
    }
}
