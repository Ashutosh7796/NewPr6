package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.Event.EventsDto;
import com.example.Project06.Dto.Event.GetSingleEventDto;
import com.example.Project06.Dto.GetAllCompanies;
import com.example.Project06.Dto.GetSingleUserDto;
import com.example.Project06.Entity.Blogs;
import com.example.Project06.Entity.Company;
import com.example.Project06.Entity.Events;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.EventsRepo;
import com.example.Project06.Service.EventService;
import com.example.Project06.exception.BlogNotFoundException;
import com.example.Project06.exception.EventNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private  final EventsRepo eventsRepo;

    @Override
    public String AddEvent(EventsDto eventsDto) {
        Events events = new Events (eventsDto);

        Events save = eventsRepo.save(events);
        return "Event Added Succesfully";

    }

    @Override
    public GetSingleEventDto getEventById(Integer eventId) {
        Optional<Events> events = eventsRepo.findById(eventId);

        if(events.isEmpty())
            {
                throw new EventNotFoundException("Event Not Found by id ");
            }
            GetSingleEventDto userDTO = new GetSingleEventDto(events.get());
            return userDTO;
        }

    @Override
    public List<GetSingleEventDto> getAllEvents(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Events> allcompanies = eventsRepo.findAll(pageable);

        List<GetSingleEventDto> getallEvents = new ArrayList<>();

        for (Events event : allcompanies) {
            GetSingleEventDto paymentDto = convertToDto(event);
            getallEvents.add(paymentDto);
        }

        return getallEvents;
    }

    @Override
    public String deleteEventById(Integer eventId) {
        eventsRepo.findById(eventId).orElseThrow(() -> new RuntimeException("Event details Not found By Id"));
        eventsRepo.deleteById(eventId);
        return "Event deleted Successfully ";
    }

    @Override
    public void updateEventDetails(GetSingleEventDto eventDto, Integer eventId) {
            Events event = eventsRepo.findById(eventId)
                    .orElseThrow(() -> new EventNotFoundException("Event Not Found", HttpStatus.NOT_FOUND));

            if (eventDto.getEventDate() != null) {
                event.setEventDate(eventDto.getEventDate());
            }
            if (eventDto.getEventName() != null) {
                event.setEventName(eventDto.getEventName());
            }
            if (eventDto.getEventTagline() != null) {
                event.setEventTagline(eventDto.getEventTagline());
            }
            if (eventDto.getEventDetails() != null) {
                event.setEventDetails(eventDto.getEventDetails());
            }
            if (eventDto.getDate() != null) {
                event.setDate(eventDto.getDate());
            }
            if (eventDto.getStatus() != null) {
                event.setStatus(eventDto.getStatus());
            }
            if (eventDto.getPhoto() != null) {
                event.setPhoto(eventDto.getPhoto());
            }
            if (eventDto.getPrice() != null) {
                event.setPrice(eventDto.getPrice());
            }

            eventsRepo.save(event);
        }

    @Override
    public List<GetSingleEventDto> getEventsByStatus(String status) {
        List<Events> listOfEventsByStatus = eventsRepo.getEventsByStatus(status);

        if (listOfEventsByStatus.isEmpty()) {
            throw new EventNotFoundException("Event not found", HttpStatus.NOT_FOUND);
        }

        return listOfEventsByStatus.stream()
                .map(events -> new GetSingleEventDto(
                        events.getEventsid(),
                        events.getEventName(),
                        events.getEventDetails(),
                        events.getEventTagline(),
                        events.getEventDate(),
                        events.getDate(),
                        events.getStatus(),
                        events.getPhoto(),
                        events.getPrice()))
                .collect(Collectors.toList());
    }


    private GetSingleEventDto convertToDto(Events events) {
        GetSingleEventDto eventsDto = new GetSingleEventDto();
        eventsDto.setEventDetails(events.getEventDetails());
        eventsDto.setEventDate(events.getEventDate());
        eventsDto.setEventName(events.getEventName());
        eventsDto.setEventTagline(events.getEventTagline());
        eventsDto.setDate(events.getDate());
        eventsDto.setStatus(events.getStatus());
        eventsDto.setPhoto(events.getPhoto());
        eventsDto.setPrice(events.getPrice());
        return eventsDto;
    }



}


