package com.example.demo.services;

import com.example.demo.DTOs.EventDTO;
import com.example.demo.config.CustomMapper;
import com.example.demo.domain.Event;
import com.example.demo.repositories.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventService implements EvService {
    private final EventRepository eventRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public EventService(EventRepository eventRepository, ObjectMapper objectMapper) {
        this.eventRepository = eventRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public long countEvents() {
        return eventRepository.count();
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = fromDtoToEvent(eventDTO);
        eventRepository.save(event);
        return fromEventToDto(event);
    }

    @Override
    public Page<Event> getEvents(Pageable pageable) {
        Page<Event> events = eventRepository.findAll(pageable);
        return events;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Событие с id=" + id + " не найдено"));
    }

    @Override
    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    @Override
    public EventDTO update(String id, EventDTO eventDTO) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("event with id " + eventDTO.getId() + " not found"));

            event.setEvent_name(eventDTO.getEvent_name());

            event.setDate(eventDTO.getDate());

            event.setLocation(eventDTO.getLocation());

            event.setParticipants(Arrays.asList(eventDTO.getParticipants()));


            event.setAudience_count(eventDTO.getAudience_count());

            event.setWinner(eventDTO.getWinner());
        Event newItem = eventRepository.save(event);
        return fromEventToDto(newItem);
    }

    @Override
    public List<Event> findEventsByWinner(String winner) {
        List<Event> events = eventRepository.findByWinner(winner);
        return events;
    }

    private Event fromDtoToEvent(EventDTO eventDTO) {
//        List<String> participantsList = CustomMapper.stringToList(eventDTO.getParticipants());
//        eventDTO.setParticipantsList(participantsList);
//        return objectMapper.convertValue(eventDTO, Event.class);
        Event event = new Event(
                eventDTO.getEvent_name(),
                eventDTO.getDate(),
                eventDTO.getLocation(),
                eventDTO.getParticipantsList(),
                eventDTO.getAudience_count(),
                eventDTO.getWinner()
        );
        return event;
    }

    private EventDTO fromEventToDto(Event event) {
        EventDTO eventDTO = new EventDTO(
                event.getId(),
                event.getEvent_name(),
                event.getLocation(),
                event.getDate(),
                CustomMapper.listToString(event.getParticipants()),
                event.getAudience_count(),
                event.getWinner()
        );
        return eventDTO;
    }
}
