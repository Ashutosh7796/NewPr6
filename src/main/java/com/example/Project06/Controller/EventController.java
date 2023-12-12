package com.example.Project06.Controller;

import com.example.Project06.Dto.*;
import com.example.Project06.Dto.Event.*;
import com.example.Project06.Dto.StudentProfileDto.GetSingleProfileDto;
import com.example.Project06.Service.EventService;
import com.example.Project06.exception.EventBookingException;
import com.example.Project06.exception.EventNotFoundException;
import com.example.Project06.exception.PageNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import com.example.Project06.utils.BaseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping(value = "/addEvent")
    public ResponseEntity<BaseResponseDTO> addevent(@RequestBody EventsDto eventsDto) {
        try {
            String response = eventService.AddEvent(eventsDto);
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseDTO("Success", response));
        } catch (EventBookingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful", "Error Occured While Adding the event"));
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getUserById(@RequestParam Integer eventId) {
        try {
            SingleEventDto responseDto = new SingleEventDto("Success");
            responseDto.setResponse(eventService.getEventById(eventId));
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (EventNotFoundException e) {
            EventUpdateDto userupdateDTO = new EventUpdateDto("Unsuccess");
            userupdateDTO.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userupdateDTO);

        }
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<ResponseAllEventsDto> getAllEvents(@RequestParam int pageNo,
                                                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            List<GetSingleEventDto> companies = eventService.getAllEvents(pageNo, pageSize);
            ResponseAllEventsDto responseAllCompnayDto = new ResponseAllEventsDto("Success");
            responseAllCompnayDto.setList(companies);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllCompnayDto);
        } catch (PageNotFoundException e) {
            ResponseAllEventsDto dto = new ResponseAllEventsDto("Unsuccess");
            dto.setException("Page Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCallById(@RequestParam Integer eventId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", eventService.deleteEventById(eventId)));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        }
    }

    @PatchMapping("/updateEventDetails")
    public ResponseEntity<?> updateDetails(@RequestBody GetSingleEventDto singleEventDto, @RequestParam Integer eventId) {
        try {
            eventService.updateEventDetails(singleEventDto, eventId);
            BlogUpdateDto userUpdateDto = new BlogUpdateDto("success");
            userUpdateDto.setMessage("Event Details Updated Successfully");

            return ResponseEntity.status(HttpStatus.OK).body(userUpdateDto);
        } catch (EventNotFoundException e) {
            BlogUpdateDto userUpdateDto = new BlogUpdateDto("Unsuccess");
            userUpdateDto.setException(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userUpdateDto);
        }
    }
    @GetMapping("/getEventsByStatus")
    public ResponseEntity<ResponseAllEventsDto> getJobsByStatusWithPages(String status) {

        try {
            List<GetSingleEventDto> listOfJobsByStatus = eventService.getEventsByStatus(status);
            ResponseAllEventsDto responseGetAllEventDto = new ResponseAllEventsDto("success");
            responseGetAllEventDto.setList(listOfJobsByStatus);
            return ResponseEntity.status(HttpStatus.OK).body(responseGetAllEventDto);
        } catch (EventNotFoundException jobNotFoundException) {
            ResponseAllEventsDto responseGetAllJobDto = new ResponseAllEventsDto("unsuccess");
            responseGetAllJobDto.setException("Event not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllJobDto);
        }
    }
}