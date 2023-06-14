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
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String username;
    String email;
    String phonenumber;
    @CreationTimestamp
    LocalDateTime created;
    @UpdateTimestamp
    LocalDateTime lastEdited;

    @OneToMany(mappedBy = "attendee")
    private List<EventAttendee> eventAttendees = new ArrayList<>();


    public Attendee(String username, String email, String phonenumber){
        this.username = username;
        this.email = email;
        this.phonenumber = phonenumber;

    }




}
