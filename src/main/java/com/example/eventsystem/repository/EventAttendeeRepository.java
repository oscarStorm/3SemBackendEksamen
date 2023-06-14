package com.example.eventsystem.repository;

import com.example.eventsystem.entity.EventAttendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventAttendeeRepository extends JpaRepository<EventAttendee, Long> {

}
