package com.example.eventsystem.dto;

import com.example.eventsystem.entity.Event;
import com.example.eventsystem.entity.Location;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class EventRequest {


    long id;
    String name;
    String date;
    String description;
    int capacity;

    private Location location;

    public EventRequest(Event event){
        this.id = event.getId();
        this.name = event.getName();
        this.date = event.getDate();
        this.description = event.getDescription();
        this.capacity = event.getCapacity();
        this.location = event.getLocation();
    }

}
