package com.example.demo.controllers;

import com.example.demo.DTOs.EventDTO;
import com.example.demo.domain.Event;
import com.example.demo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public Page<Event> getEventsPage(
            @RequestParam(defaultValue = "0") Integer offset,              // Номер страницы
            @RequestParam(defaultValue = "10") Integer limit     // Количество элементов на странице
    ) {
        return eventService.getEvents(PageRequest.of(offset, limit));
    }

    @GetMapping("/events/{id}")
    public Event getEvents(@PathVariable String id) {
        return eventService.getEvent(id);
    }

    @PostMapping("/events")
    public EventDTO postEvent(@RequestBody EventDTO eventDTO) {
        return eventService.createEvent(eventDTO);
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }

    @PutMapping("/events/{id}")
    public EventDTO putEvents(@RequestBody EventDTO eventDTO, @PathVariable String id) {
        return eventService.update(id,eventDTO);
    }

//    @GetMapping("/events/{winner}")
//    public List<Event> findEventsByWinner(@PathVariable String winner) {
//        return eventService.findEventsByWinner(winner);
//    }
}
