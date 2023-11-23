package com.example.Project06.Controller;

import com.example.Project06.Dto.MentorProfileDto.MentorProfileDto;
import com.example.Project06.Dto.MentorProfileDto.ResponseAllMentorDto;
import com.example.Project06.Dto.MentorProfileDto.ResponseMentorSingleDto;
import com.example.Project06.Dto.MentorProgramDto.MentorProgramDto;
import com.example.Project06.Dto.MentorProgramDto.ResponseAllMentorProgramDto;
import com.example.Project06.Dto.MentorProgramDto.ResponseMentorProgramSingleDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.IMentorProgram;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentorprogram")
@AllArgsConstructor
public class MentorProgramController {

private final IMentorProgram iMentorProgram;
    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody MentorProgramDto mentorProgramDto)
    {
        try {

            iMentorProgram.save(mentorProgramDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success","mentor program details added"));

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("unsuccess",e.getMessage()));

        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(Integer mentorProgramId)
    {
        try {
            ResponseMentorProgramSingleDto responseSingleDto = new ResponseMentorProgramSingleDto("success");
            responseSingleDto.setResponse(iMentorProgram.getById(mentorProgramId));
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
            ResponseAllMentorProgramDto responseObjectDto = new ResponseAllMentorProgramDto("success");
            responseObjectDto.setResponse(iMentorProgram.getAll());
            return ResponseEntity.status(HttpStatus.OK).body(responseObjectDto);
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

}
