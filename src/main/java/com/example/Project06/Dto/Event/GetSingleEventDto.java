package com.example.Project06.Dto.Event;

import com.example.Project06.Entity.Events;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class GetSingleEventDto {

    private Integer eventsid;

    private String eventName;

    private String eventDetails;

    private String eventTagline;

    private LocalDate eventDate;

    private LocalDate date;

    private String status;

    private String photo;

    private String price;

    public GetSingleEventDto(Events events) {
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

    public GetSingleEventDto(Integer eventsid, String eventName, String eventDetails, String eventTagline,
                             LocalDate eventDate, LocalDate date, String status, String photo, String price) {
        this.eventsid = eventsid;
        this.eventName = eventName;
        this.eventDetails = eventDetails;
        this.eventTagline = eventTagline;
        this.eventDate = eventDate;
        this.date = date;
        this.status = status;
        this.photo = photo;
        this.price = price;
    }
}
