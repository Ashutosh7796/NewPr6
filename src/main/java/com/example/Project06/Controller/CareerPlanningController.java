package com.example.Project06.Controller;

import com.example.Project06.Dto.MentorScheduleDto.MentorScheduleDto;
import com.example.Project06.Dto.Planning.CareerPlaningDto;
import com.example.Project06.Dto.Planning.ResponseAllCareersDto;
import com.example.Project06.Dto.Planning.ResponseCareerPlansDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Dto.hr.ResponseAllHrDtos;
import com.example.Project06.Dto.hr.ResponseHrSingleDto;
import com.example.Project06.Service.CareerPlanningService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/CareerPlanning")
@AllArgsConstructor
public class CareerPlanningController {

    private final CareerPlanningService careerPlanningService;


    @PostMapping("/post")
    public ResponseEntity<?> CareerPlans(@RequestBody CareerPlaningDto careerPlaningDto)
    {
        try {

            careerPlanningService.createCareerPlan(careerPlaningDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success","career plans details added"));

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("unsuccess",e.getMessage()));

        }
    }


    @GetMapping("/getById")
    public ResponseEntity<?> getById(Integer CareerPlanning)
    {
        try {
            ResponseCareerPlansDto responseCareerPlansDto = new ResponseCareerPlansDto("success");
            responseCareerPlansDto.setResponse(careerPlanningService.getPlanById(CareerPlanning));
            return ResponseEntity.status(HttpStatus.OK).body(responseCareerPlansDto);
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }


    @GetMapping("/getAllCareerPlans")

    public ResponseEntity<?> getById() {
        try {
            ResponseAllCareersDto responseAllCareersDto = new ResponseAllCareersDto("success");
            responseAllCareersDto.setResponse(careerPlanningService.getAllCareerPlans());
            return ResponseEntity.status(HttpStatus.OK).body(responseAllCareersDto);
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }


    @PatchMapping("/update")
    public ResponseEntity<?> updateById(

            @RequestParam String domain,

            @RequestParam String mode,

            @RequestParam OffsetDateTime slot,

            @RequestParam String cost,

            @RequestParam String status,

            @RequestParam Integer careerPlanning



    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",careerPlanningService.updateCareerPlans(
                    domain,mode,slot,cost,status,careerPlanning

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
    public ResponseEntity<?> deleteById( @RequestParam Integer careerPlanning) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",careerPlanningService.deleteById(careerPlanning)));
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }



}
