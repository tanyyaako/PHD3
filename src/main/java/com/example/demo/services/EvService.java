package com.example.demo.services;

import com.example.demo.DTOs.EventDTO;
import com.example.demo.domain.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EvService {
    long countEvents();
    EventDTO createEvent(EventDTO eventDTO);
    Page<Event> getEvents(Pageable pageable);
    List<Event> getAllEvents();
    Event getEvent(String id);
    void deleteEvent(String id);
    void deleteAllEvents();
    EventDTO update(String id, EventDTO eventDTO);
    List<Event> findEventsByWinner(String winner);
}
