package com.example.eventsystem.repository;

import com.example.eventsystem.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeRepository extends JpaRepository<Attendee, Long> {
}
