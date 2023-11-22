package com.example.Project06.Service;

import com.example.Project06.Dto.Event.EventsDto;
import com.example.Project06.Dto.Event.GetSingleEventDto;
import com.example.Project06.Dto.GetAllCompanies;
import com.example.Project06.Dto.GetAllUserDTO;

import java.util.List;


public interface EventService {

    String AddEvent(EventsDto eventsDto);

    public GetSingleEventDto getEventById(Integer eventId);

    List<GetSingleEventDto> getAllEvents(int pageNo, int pageSize);
}
