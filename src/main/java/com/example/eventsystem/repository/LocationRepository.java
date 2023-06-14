package com.example.eventsystem.repository;

import com.example.eventsystem.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
