package com.example.eventsystem.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class EventAttendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private Event event;

    @ManyToOne
    @JoinColumn
    private Attendee attendee;

    private LocalDateTime registrationDate;

    public EventAttendee(Event event, Attendee attendee, LocalDateTime registrationDate){

        this.event = event;
        this.attendee = attendee;
        this.registrationDate = registrationDate;

    }


}
