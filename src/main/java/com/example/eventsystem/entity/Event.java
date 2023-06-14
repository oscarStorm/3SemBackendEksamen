package com.example.eventsystem.entity;

import com.example.eventsystem.LocationSerializer;
import com.example.eventsystem.dto.EventRequest;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String name;
    String date;
    String description;
    int capacity;
    @CreationTimestamp
    LocalDateTime created;
    @UpdateTimestamp
    LocalDateTime lastEdited;

    @JsonSerialize(using = LocationSerializer.class)
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;


    @OneToMany(mappedBy = "event")
    private List<EventAttendee> eventAttendees = new ArrayList<>();

    public Event(EventRequest er){
        this.name = er.getName();
        this.date = er.getDate();
        this.description = er.getDescription();
        this.capacity = er.getCapacity();
        this.location = er.getLocation();
    }

    public Event(String name, String date, String description, int capacity, Location location){

        this.name = name;
        this.date = date;
        this.description = description;
        this.capacity = capacity;
        this.location = location;

    }




}
