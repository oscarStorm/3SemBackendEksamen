package com.example.eventsystem.config;

import com.example.eventsystem.entity.Attendee;
import com.example.eventsystem.entity.Event;
import com.example.eventsystem.entity.EventAttendee;
import com.example.eventsystem.entity.Location;
import com.example.eventsystem.repository.AttendeeRepository;
import com.example.eventsystem.repository.EventAttendeeRepository;
import com.example.eventsystem.repository.EventRepository;
import com.example.eventsystem.repository.LocationRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class DeveloperData implements ApplicationRunner {

    AttendeeRepository attendeRepository;
    EventRepository eventRepository;
    LocationRepository locationRepository;
    EventAttendeeRepository eventAttendeeRepository;

    public DeveloperData(AttendeeRepository attendeRepository, EventRepository eventRepository, LocationRepository locationRepository, EventAttendeeRepository eventAttendeeRepository){
        this.attendeRepository = attendeRepository;
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
        this.eventAttendeeRepository = eventAttendeeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        LocalDateTime registrationDate = LocalDateTime.now();

        Location l1 = new Location("rolighedsvej 100","forum", 5000);
        Location l2 = new Location("langt ude på amager 100","royal arena", 10000);

        Event e1 = new Event("Beatles","02/06/2023","Rock", 10000,l1);

        Attendee a1 = new Attendee("oscar","oscar@gmail.com","23123212");

        EventAttendee eA1 = new EventAttendee(e1,a1,registrationDate);




        locationRepository.save(l1);
        locationRepository.save(l2);

        attendeRepository.save(a1);

        eventRepository.save(e1);

        eventAttendeeRepository.save(eA1);






    }
}
