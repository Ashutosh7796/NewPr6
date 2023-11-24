package com.example.Project06.Dto.Event;

import com.example.Project06.Entity.Events;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class EventsDto {
    private Integer eventsid;

    private String eventName;

    private String eventDetails;

    private String eventTagline;

    private LocalDate eventDate;

    private LocalDate date;

    private String status;

    private String photo;

    private String price;

    public EventsDto(Events events) {
        this.eventsid = events.getEventsid();
        this.eventName = events.getEventName();
        this.eventDetails = events.getEventDetails();
        this.eventTagline = events.getEventTagline();
        this.eventDate = events.getEventDate();
        this.date = events.getDate();
        this.status = events.getStatus();
        this.photo = events.getPhoto();
        this.price = events.getPrice();
    }
}

