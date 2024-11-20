package com.example.demo.DTOs;

import com.example.demo.config.CustomMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventDTO {
    private String id;
    private String event_name;
    private String date;
    private String location;
    private String participants;
    private String winner;
    private Long audience_count;


    public EventDTO(String id, String event_name, String location, String  date, String participants, Long audience_count, String winner) {
        this.id = id;
        this.event_name = event_name;
        this.date = date;
        this.location = location;
        this.participants = participants;
        this.winner = winner;
        this.audience_count = audience_count;

    }
    public EventDTO() {

    }

    public Long getAudience_count() {
        return audience_count;
    }

    public void setAudience_count(Long audience_count) {
        this.audience_count = audience_count;
    }

    public String  getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public List<String> getParticipantsList() {
        return CustomMapper.stringToList(this.participants);
    }
    public void setParticipantsList(List<String> participantsList) {
        this.participants = CustomMapper.listToString(participantsList);
    }
}
