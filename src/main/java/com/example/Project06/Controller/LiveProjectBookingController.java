package com.example.Project06.Controller;

import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Dto.liveProjectBooking.LiveProjectBookingDto;
import com.example.Project06.Dto.liveProjectBooking.ResponseAllLiveProjectBookingDto;
import com.example.Project06.Dto.liveProjectBooking.ResponseSingleLiveProjectBookingDto;
import com.example.Project06.Service.LiveProjectBookingService;
import com.example.Project06.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/LiveProjectBooking")
public class LiveProjectBookingController {


    private final LiveProjectBookingService liveProjectBookingService;
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> LiveProjectAdd(@RequestBody LiveProjectBookingDto liveProjectBookingDto)
    {
        try {
            String result = liveProjectBookingService.AddLiveProjectBooking(liveProjectBookingDto);
            return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",result)));
        }catch (LiveProjectNotFoundException liveProjectNotFoundException)
        {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsucces","IT Training not found")));
        }
        catch (UserNotFoundExceptions userNotFoundExceptions)
        {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsucces","IT Training not found")));
        }

    }


    @GetMapping("/ById")
    public ResponseEntity<ResponseSingleLiveProjectBookingDto> getItTrainingBookingById(@RequestParam Integer liveProjectBookingId) {
        try {
            ResponseSingleLiveProjectBookingDto responseSingleLiveProjectBookingDto = new ResponseSingleLiveProjectBookingDto("success");
            LiveProjectBookingDto liveProjectBookingDto = liveProjectBookingService.GetbyId(liveProjectBookingId);
            responseSingleLiveProjectBookingDto.setObject(liveProjectBookingDto);

            return ResponseEntity.status(HttpStatus.OK).body(responseSingleLiveProjectBookingDto);
        } catch (LiveProjectBookingNotFoundException liveProjectBookingNotFoundException)
        {
            ResponseSingleLiveProjectBookingDto responseSingleLiveProjectBookingDto = new ResponseSingleLiveProjectBookingDto("unsuccess");
            responseSingleLiveProjectBookingDto.setException("booking not found");
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseSingleLiveProjectBookingDto));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseAllLiveProjectBookingDto> getAllItTrainingBookings() {
        try {
            ResponseAllLiveProjectBookingDto responseAllLiveProjectBookingDto = new ResponseAllLiveProjectBookingDto("Success");
            List<LiveProjectBookingDto> liveProjectBookingDtos = liveProjectBookingService.AllLiveProjectBooking();
            responseAllLiveProjectBookingDto.setList(liveProjectBookingDtos);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllLiveProjectBookingDto);

        } catch (LiveProjectBookingNotFoundException liveProjectBookingNotFoundException) {
            ResponseAllLiveProjectBookingDto responseAllLiveProjectBookingDto = new ResponseAllLiveProjectBookingDto("unsuccess");
            responseAllLiveProjectBookingDto.setException("live project not found booking not found");
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllLiveProjectBookingDto));

        }
    }

    @GetMapping("/ByLiveProjectId")
    public ResponseEntity<ResponseAllLiveProjectBookingDto> getAllLiveProjectBookingsByItTrainingId(@RequestParam Integer liveProjectId) {
        try {
            ResponseAllLiveProjectBookingDto responseAllLiveProjectBookingDto = new ResponseAllLiveProjectBookingDto("Success");
            List<LiveProjectBookingDto> liveProjectBookingDtos = liveProjectBookingService.getAllByliveProjectID(liveProjectId);
            responseAllLiveProjectBookingDto.setList(liveProjectBookingDtos);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllLiveProjectBookingDto);

        }catch (LiveProjectBookingNotFoundException liveProjectBookingNotFoundException) {
            ResponseAllLiveProjectBookingDto responseAllLiveProjectBookingDto = new ResponseAllLiveProjectBookingDto("unsuccess");
            responseAllLiveProjectBookingDto.setException("live project not found booking not found by project id");
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllLiveProjectBookingDto));

        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLiveProjectBooking(@RequestParam Integer liveProjectBookingId) {
        try {
            String result = liveProjectBookingService.LiveProjectBookingDelete(liveProjectBookingId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (LiveProjectBookingNotFoundException liveProjectBookingNotFoundException) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "live project  booking not found"));
        }
    }

    @GetMapping("/byUserId")
    public ResponseEntity<ResponseAllLiveProjectBookingDto> getLiveProjectBookingsByUserId(@RequestParam Integer userId) {
        try {
            ResponseAllLiveProjectBookingDto responseAllLiveProjectBookingDto = new ResponseAllLiveProjectBookingDto("success");
            List<LiveProjectBookingDto> liveProjectBookingDtos = liveProjectBookingService.getByUserId(userId);
            responseAllLiveProjectBookingDto.setList(liveProjectBookingDtos);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllLiveProjectBookingDto);
        } catch (LiveProjectBookingNotFoundException liveProjectBookingNotFoundException) {
            ResponseAllLiveProjectBookingDto responseAllLiveProjectBookingDto = new ResponseAllLiveProjectBookingDto("success");
            responseAllLiveProjectBookingDto.setException("user live project booking not found");
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllLiveProjectBookingDto));
        }catch (UserNotFoundExceptions userNotFoundExceptions) {
            ResponseAllLiveProjectBookingDto responseAllLiveProjectBookingDto = new ResponseAllLiveProjectBookingDto("success");
        responseAllLiveProjectBookingDto.setException("user booking not found");
        return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllLiveProjectBookingDto));}
    }



}
