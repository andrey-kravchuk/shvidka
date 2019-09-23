package com.stfl.service;

import com.stfl.dao.EventRepository;
import com.stfl.dao.HospitalRepository;
import com.stfl.dao.UserProfileRepository;
import com.stfl.dto.EventDto;
import com.stfl.exception.EventNotFoundException;
import com.stfl.exception.HospitalNotFoundException;
import com.stfl.exception.UserProfileNotFoundException;
import com.stfl.model.Event;
import com.stfl.model.EventInfo;
import com.stfl.model.UserProfile;
import com.stfl.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventService {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserProfileRepository profileRepo;

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private HospitalRepository hospitalRepo;

    public EventDto findEvent(Long id) {
        Event event = eventRepo.findEventById(id)
                .orElseThrow(() -> new EventNotFoundException());
        return new EventDto(event);
    }

    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepo.findAll();
        return transformEventType(events);
    }

    public List<EventDto> findActiveEvents() {
        List<Event> events = eventRepo.findAll()
                .stream()
                .filter(st -> st.getStatus().equals("active"))
                .collect(Collectors.toList());
        return transformEventType(events);
    }

    public List<EventDto> findAcceptedEvents() {
        List<Event> events = eventRepo.findAll()
                .stream()
                .filter(st -> st.getStatus().equals("accepted"))
                .collect(Collectors.toList());
        return transformEventType(events);
    }

    public List<EventDto> findCanceledEvents() {
        List<Event> events = eventRepo.findAll()
                .stream()
                .filter(st -> st.getStatus().equals("canceled"))
                .collect(Collectors.toList());
        return transformEventType(events);
    }

    public List<EventDto> findClosedEvents() {
        List<Event> events = eventRepo.findAll()
                .stream()
                .filter(st -> st.getStatus().equals("closed"))
                .collect(Collectors.toList());
        return transformEventType(events);
    }

    @Transactional
    public EventDto createEvent(Long patientId, Long hospitalId, boolean otherAddress) {
        Event createdEvent = new Event();
        ApplicationUser user = securityService.getUserFromSession();
        createdEvent.setCaller(user.getUserProfile());
        createdEvent.setCallerEmail(user.getEmail());
        UserProfile profile = profileRepo
                .findUserProfileById(patientId)
                .orElseThrow(() -> new UserProfileNotFoundException());
        createdEvent.setPatient(profile);
        if(!otherAddress) {
            createdEvent.setAddress(profile.getAddress());
        }
        createdEvent.setHospital(hospitalRepo
                .findById(hospitalId)
                .orElseThrow(() -> new HospitalNotFoundException()));
        createdEvent.setStatus("active");
        createdEvent.setDateTime(LocalDateTime.now());
        return new EventDto(eventRepo.saveAndFlush(createdEvent));
    }

    public EventDto acceptEvent(Long id) {
        Event event = eventRepo.findEventById(id)
                .orElseThrow(() -> new EventNotFoundException());
        event.setStatus("accepted");
        return new EventDto(eventRepo.saveAndFlush(event));
    }

    @Transactional
    public EventDto closeEvent(Long id, EventInfo eventInfo) {
        Event event = eventRepo.findEventById(id)
                .orElseThrow(() -> new EventNotFoundException());
        event.setEventInfo(eventInfo);
        event.setStatus("closed");
        return new EventDto(eventRepo.saveAndFlush(event));
    }

    @Transactional
    public EventDto cancelEvent(Long id, String note) {
        Event event = eventRepo.findEventById(id)
                .orElseThrow(() -> new EventNotFoundException());
        event.setStatus("canceled");
        event.setNoteOfCall(note);
        return new EventDto(eventRepo.saveAndFlush(event));
    }

    private List<EventDto> transformEventType(List<Event> list) {
        List<EventDto> listDto = new ArrayList<>(list.size());
        for (Event event : list) {
            listDto.add(new EventDto(event));
        }
        return listDto;
    }
}
