package com.example.demo.repositories;

import com.example.demo.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    @Query("{winner: {$eq: ?0}}")
    List<Event> findByWinner(String winner);
    Optional<Event> findById(String id);
}
