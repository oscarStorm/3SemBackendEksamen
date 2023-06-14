package com.example.eventsystem.service;


import com.example.eventsystem.entity.Attendee;
import com.example.eventsystem.entity.Event;
import com.example.eventsystem.entity.EventAttendee;
import com.example.eventsystem.repository.AttendeeRepository;
import com.example.eventsystem.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttendeeService {

    EventRepository eventRepository;
    AttendeeRepository attendeeRepository;


    public AttendeeService(EventRepository eventRepository, AttendeeRepository attendeRepository){
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeRepository;

    }
    /*

    public String registerToEvent(long eventId, long attendeeId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        Optional<Attendee> optionalAttendee = attendeeRepository.findById(attendeeId);

        if (optionalEvent.isPresent() && optionalAttendee.isPresent()) {
            Event event = optionalEvent.get();
            Attendee attendee = optionalAttendee.get();

            if (event.getEventAttendees().size() < event.getCapacity()) {
                EventAttendee eventAttendee = new EventAttendee(event, attendee);
                event.getEventAttendees().add(eventAttendee);
                eventRepository.save(event);
                return "Attendee registered to the event successfully";
            } else {
                return "Event is at full capacity";
            }
        } else {
            return "Event or Attendee not found";
        }
    }

     */


}
