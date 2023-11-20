package com.example.Project06.Controller;

import com.example.Project06.Dto.MentorFeedBack.MentorFeedBackDto;
import com.example.Project06.Dto.MentorFeedBack.ResponseAllMentorFeedbackDtO;
import com.example.Project06.Dto.MentorFeedBack.ResponseMentorFeedbackSingleDto;
import com.example.Project06.Dto.MentorProfileDto.MentorProfileDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Repository.MentorFeedBackRepo;
import com.example.Project06.Service.IMentorFeedBack;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/mentorfeedback")
public class MentorFeedbackController {

private final IMentorFeedBack mentorFeedBack;

    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody MentorFeedBackDto mentorProfileDto)
    {
        try {

            mentorFeedBack.save(mentorProfileDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success","mentor details added"));

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("unsuccess",e.getMessage()));

        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(Integer mentorFeedbackId)
    {
        try {
            ResponseMentorFeedbackSingleDto responseSingleDto = new ResponseMentorFeedbackSingleDto("success");
            responseSingleDto.setResponse(mentorFeedBack.getById(mentorFeedbackId));
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
            ResponseAllMentorFeedbackDtO responseObjectDto = new ResponseAllMentorFeedbackDtO("success");
            responseObjectDto.setResponse(mentorFeedBack.getAll());
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
            @RequestParam String feedback,
            @RequestParam Integer mentorFeedbackId



    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",mentorFeedBack.updateById(
                    feedback,
                    mentorFeedbackId


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
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",mentorFeedBack.deleteById(mentorId)));
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }
}
