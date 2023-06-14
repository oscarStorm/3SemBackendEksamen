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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;
    private String name;
    private int capacity;
    @CreationTimestamp
    LocalDateTime created;
    @UpdateTimestamp
    LocalDateTime lastEdited;

    @OneToMany(mappedBy = "location")
    private List<Event> events = new ArrayList<>();


    public Location(String address, String name, int capacity){

        this.address = address;
        this.name = name;
        this.capacity = capacity;

    }









}
