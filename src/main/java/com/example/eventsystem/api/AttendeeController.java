package com.example.eventsystem.api;



import com.example.eventsystem.service.AttendeeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/attendee/")
public class AttendeeController {

    AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService){
        this.attendeeService = attendeeService;

    }




}
