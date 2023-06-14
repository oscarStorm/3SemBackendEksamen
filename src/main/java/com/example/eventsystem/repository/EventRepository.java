package com.example.eventsystem.repository;

import com.example.eventsystem.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

        List<Event> findByName(String name);
}
