package com.example.eventsystem.api;

import com.example.eventsystem.dto.EventRequest;
import com.example.eventsystem.dto.EventResponse;
import com.example.eventsystem.entity.Event;
import com.example.eventsystem.service.AttendeeService;
import com.example.eventsystem.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/event/")
public class EventController {

    EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;

    }

    @GetMapping("all")
    List<EventResponse> getAll(){
        return eventService.getAll();
    }

    @PostMapping()
    EventResponse addEvent(@RequestBody EventRequest body){
        return eventService.addEvent(body);
    }

    @GetMapping("{id}")
    EventResponse getEventByid(@PathVariable long id)throws Exception{
        return eventService.findEventById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Boolean> editNews(@PathVariable long id, @RequestBody EventRequest body) {
        eventService.editEvent(body,id);
        return ResponseEntity.ok(true);
    }




}
