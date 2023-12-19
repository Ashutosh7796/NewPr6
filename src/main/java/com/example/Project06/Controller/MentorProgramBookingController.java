package com.example.Project06.Controller;

import com.example.Project06.Dto.MentorProgramBookingDTO.MentorProgramBookingDto;
import com.example.Project06.Dto.MentorProgramBookingDTO.ResponseAllMentorProgramBookingDto;
import com.example.Project06.Dto.MentorProgramBookingDTO.ResponseMentorProtgramBookingSingleDto;

import com.example.Project06.Dto.ResponseDto;

import com.example.Project06.Service.IMentorProgramBooking;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@AllArgsConstructor
@RequestMapping("/mentorProgramBooking")
public class MentorProgramBookingController {
    private final IMentorProgramBooking iMentorProgramBooking;
    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody MentorProgramBookingDto mentorProgramBookingDto)
    {
        try {

            iMentorProgramBooking.save(mentorProgramBookingDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success","mentor program booking details added"));

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("unsuccess",e.getMessage()));

        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(Integer mentorProgramBookingId)
    {
        try {
            ResponseMentorProtgramBookingSingleDto responseMentorProtgramBookingSingleDto = new ResponseMentorProtgramBookingSingleDto("success");
            responseMentorProtgramBookingSingleDto.setResponse(iMentorProgramBooking.getById(mentorProgramBookingId));
            return ResponseEntity.status(HttpStatus.OK).body(responseMentorProtgramBookingSingleDto);
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getById() {
        try {
            ResponseAllMentorProgramBookingDto responseObjectDto = new ResponseAllMentorProgramBookingDto("success");
            responseObjectDto.setResponse(iMentorProgramBooking.getAll());
            return ResponseEntity.status(HttpStatus.OK).body(responseObjectDto);
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }



    @PatchMapping("/update")
    public ResponseEntity<?> updateById(
            @RequestParam LocalDate date,
            @RequestParam String mentorProgramBookingscol,
            @RequestParam Integer mentorProgramBookingId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iMentorProgramBooking.updateBootcampDetails(
                    date,mentorProgramBookingscol,mentorProgramBookingId

            )));
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById( @RequestParam Integer mentorProgramBookingId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iMentorProgramBooking.deleteById(mentorProgramBookingId)));
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }
}
