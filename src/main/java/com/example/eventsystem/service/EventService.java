package com.example.eventsystem.service;


import com.example.eventsystem.EventNotFoundException;
import com.example.eventsystem.dto.EventRequest;
import com.example.eventsystem.dto.EventResponse;
import com.example.eventsystem.entity.Event;
import com.example.eventsystem.repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    EventRepository eventRepository;

    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public List<EventResponse> getAll() {
        return eventRepository.findAll()
                .stream()
                .map(EventResponse::new)
                .collect(Collectors.toList());
    }

    public EventResponse addEvent(EventRequest er) {

        Event event = new Event(er);

        event = eventRepository.save(event);
        return new EventResponse(event);


    }

    public EventResponse findEventById(long id) {
        Event event = findEvent(id);
        EventResponse eventResponse = new EventResponse(event);
        return eventResponse;
    }

    public Event findEvent(long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event with ID " + id + " does not exist"));
    }

    public ResponseEntity<Boolean> editEvent(EventRequest body, long id) {

        Event eventToEdit =  findEvent(id);

        Optional.ofNullable(body.getName()).ifPresent(eventToEdit::setName);
        Optional.ofNullable(body.getDate()).ifPresent(eventToEdit::setDate);
        Optional.ofNullable(body.getDescription()).ifPresent(eventToEdit::setDescription);
        Optional.ofNullable(body.getCapacity()).ifPresent(eventToEdit::setCapacity);
        Optional.ofNullable(body.getLocation()).ifPresent(eventToEdit::setLocation);

        eventRepository.save(eventToEdit);

        return new ResponseEntity(true, HttpStatus.OK);

    }
}
