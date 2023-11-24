package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.Event.EventsDto;
import com.example.Project06.Dto.Event.GetSingleEventDto;
import com.example.Project06.Dto.GetAllCompanies;
import com.example.Project06.Dto.GetSingleUserDto;
import com.example.Project06.Entity.Company;
import com.example.Project06.Entity.Events;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.EventsRepo;
import com.example.Project06.Service.EventService;
import com.example.Project06.exception.EventNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


