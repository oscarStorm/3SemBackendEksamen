package com.example.eventsystem.entity;

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
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "event")
    private List<EventAttendee> eventAttendees = new ArrayList<>();

    public Event(String name, String date, String description, int capacity, Location location){

        this.name = name;
        this.date = date;
        this.description = description;
        this.capacity = capacity;
        this.location = location;

    }




}
