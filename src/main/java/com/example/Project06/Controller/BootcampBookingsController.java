package com.example.Project06.Controller;

import com.example.Project06.Dto.BootcampBookingsDto.BootcampBookingsDto;
import com.example.Project06.Dto.BootcampBookingsDto.ResponseAllBootcampBookingsDto;
import com.example.Project06.Dto.BootcampBookingsDto.ResponseBootcampBookingsDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Dto.hr.HrDto;
import com.example.Project06.Dto.hr.ResponseAllHrDtos;
import com.example.Project06.Dto.hr.ResponseHrSingleDto;
import com.example.Project06.Service.IBootcampBookings;
import com.example.Project06.Service.IHr;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/bootcampbookings")
@AllArgsConstructor
public class BootcampBookingsController {
    private final IBootcampBookings iBootcampBookings;

    @PostMapping("/post")
    public ResponseEntity<?> saveBootcampDetails(@RequestBody BootcampBookingsDto bootcampBookingsDto)
    {
        try {

            iBootcampBookings.save(bootcampBookingsDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success","bootcampdetails details added"));

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("unsuccess",e.getMessage()));

        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(Integer bootcampId)
    {
        try {
            ResponseBootcampBookingsDto responseSingleDto = new ResponseBootcampBookingsDto("success");
            responseSingleDto.setResponse(iBootcampBookings.getById(bootcampId));
            return ResponseEntity.status(HttpStatus.OK).body(responseSingleDto);
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

    @GetMapping("/getAll")

    public ResponseEntity<?> getAll() {
        try {
            ResponseAllBootcampBookingsDto responseObjectDto = new ResponseAllBootcampBookingsDto("success");
            responseObjectDto.setResponse(iBootcampBookings.getAllBootcampDetails());
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

            @RequestParam OffsetDateTime date,

            @RequestParam String status,

            @RequestParam Integer bootcampbookingId

    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iBootcampBookings.updateBootcampDetails(
                    date,status,bootcampbookingId

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
    public ResponseEntity<?> deleteById( @RequestParam Integer bootcampbookingId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iBootcampBookings.deleteById(bootcampbookingId)));
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }
}
