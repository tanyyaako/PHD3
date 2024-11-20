package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "event")
public class Event {
    @Id
    private String id;
    @Field(name="event_name")
    private String event_name;
    @Field(name="location")
    @Indexed(unique = false, sparse = true, direction = IndexDirection.ASCENDING, background = false)
    private String location;
    @Field(name="date")
    private String date;
    @Field(name="participants")
    private List<String> participants;
    @Field(name="winner")
    private String winner;
    @Field(name="audience_count")
    private Long audience_count;

    public Event(String event_name, String  date, String location, List<String> participants, Long audience_count, String winner) {
        this.audience_count = audience_count;
        this.date = date;
        this.event_name = event_name;
        this.location = location;
        this.participants = participants;
        this.winner = winner;
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

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}

