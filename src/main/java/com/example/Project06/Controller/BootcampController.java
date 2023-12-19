package com.example.Project06.Controller;


import com.example.Project06.Dto.BootcampDto.BootcampDto;
import com.example.Project06.Dto.BootcampDto.ResponseAllBootcampDetails;
import com.example.Project06.Dto.BootcampDto.ResponseSingleDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.IBootcamp;
import com.example.Project06.exception.BannerNotFoundByIdException;
import com.example.Project06.exception.BootcampNotFoundByIdException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bootcamp")
public class BootcampController {

    private final IBootcamp iBootcamp;
    @PostMapping("/post")
    public ResponseEntity<?> saveBootcampDetails(@RequestBody BootcampDto bootcampDto)
    {
        iBootcamp.saveBootcampDetails(bootcampDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success","Bootcamp details added"));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(Integer bootcampId)
    {
        try {
            ResponseSingleDto responseSingleDto = new ResponseSingleDto("success");
            responseSingleDto.setBootcamp(iBootcamp.getBootcampDetailsById(bootcampId));
            return ResponseEntity.status(HttpStatus.OK).body(responseSingleDto);
        }catch (BootcampNotFoundByIdException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }
//
    @GetMapping("/getAllBootcampDetails")

    public ResponseEntity<?> getById() {
        try {
            ResponseAllBootcampDetails responseObjectDto = new ResponseAllBootcampDetails("success");
            responseObjectDto.setBootcamps(iBootcamp.getAllBootcampDetails());
            return ResponseEntity.status(HttpStatus.OK).body(responseObjectDto);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateById(
            @RequestParam String bootcampTital,

            @RequestParam String bootcampDetails,

            @RequestParam String time,

            @RequestParam String status,

            @RequestParam String location,

            @RequestParam String tagLine,

            @RequestParam String photo,

            @RequestParam String price,

            @RequestParam Integer bootCampId


    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iBootcamp.updateBootcampDetails(
                    bootcampTital,
                    bootcampDetails,
                    time,
                    status,
                    location,
                    tagLine,
                    photo,
                    price,
                    bootCampId

            )));
        }catch (BannerNotFoundByIdException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById( @RequestParam Integer bootcampId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iBootcamp.deleteBootcampDetailsByID(bootcampId)));
        }catch (BannerNotFoundByIdException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }





}
