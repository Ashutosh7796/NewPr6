package com.example.Project06.Controller;

import com.example.Project06.Dto.MentorProfileDto.MentorProfileDto;
import com.example.Project06.Dto.MentorProfileDto.ResponseAllMentorDto;
import com.example.Project06.Dto.MentorProfileDto.ResponseMentorSingleDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.IMentor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/mentor")
public class MentorController {
    private final IMentor iMentor;

    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody MentorProfileDto mentorProfileDto)
    {
        try {

            iMentor.save(mentorProfileDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success","mentor feedback details added"));

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("unsuccess",e.getMessage()));

        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(Integer mentorId)
    {
        try {
            ResponseMentorSingleDto responseSingleDto = new ResponseMentorSingleDto("success");
            responseSingleDto.setResponse(iMentor.getById(mentorId));
            return ResponseEntity.status(HttpStatus.OK).body(responseSingleDto);
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

    @GetMapping("/getAll")

    public ResponseEntity<?> getById() {
        try {
            ResponseAllMentorDto responseObjectDto = new ResponseAllMentorDto("success");
            responseObjectDto.setResponse(iMentor.getAll());
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
            @RequestParam String specialityOfMentor,
            @RequestParam String skills,
            @RequestParam String subject,
            @RequestParam String mentorInfo,
            @RequestParam String achievements,
            @RequestParam String socalMediaLinkF,
            @RequestParam String socalMediaLinkF1,
            @RequestParam String socalMediaLinkInsta,
            @RequestParam String cost,
            @RequestParam Integer mentorId



    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iMentor.updateById(
                    specialityOfMentor,
                    skills,
                    subject,
                    mentorInfo,
                    achievements,
                    socalMediaLinkF,
                    socalMediaLinkF1,
                    socalMediaLinkInsta,
                    cost,
                    mentorId

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
    public ResponseEntity<?> deleteById( @RequestParam Integer mentorId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iMentor.deleteById(mentorId)));
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }
}
