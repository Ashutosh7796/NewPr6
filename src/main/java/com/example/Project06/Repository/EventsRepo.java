package com.example.Project06.Repository;

import com.example.Project06.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepo extends JpaRepository <Events, Integer> {

    public List<Events> getEventsByStatus(String status);
}
