package com.example.eventsystem.dto;

import com.example.eventsystem.entity.Event;
import com.example.eventsystem.entity.Location;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventResponse {

    long id;
    String name;
    String date;
    String description;

    private Location location;


    public EventResponse(Event event){

        this.id = event.getId();
        this.name = event.getName();
        this.date = event.getDate();
        this.description = event.getDescription();

    }


}
