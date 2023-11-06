package com.example.Project06.Controller;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import com.example.Project06.Dto.ItTrianningBooking.ResponseSingleItTrainingBookingDTO;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.ItTrainingBookingService;
import com.example.Project06.exception.ItTrainingBookingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ItTrainingBooking")
public class ItTrianningBookingController {



    private final ItTrainingBookingService itTrainingBookingService;
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> ItTrainingadd(@RequestBody ItTrianningBookingDto itTrianningBookingDto)
    {
        try {
            String result = itTrainingBookingService.AddItTrainingBooking(itTrianningBookingDto);
            return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",result)));
        }catch (ItTrainingBookingException itTrainingBookingException)
        {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsucces","IT Training not found")));
        }
    }

    @GetMapping("/ById")
    public ResponseEntity<ResponseSingleItTrainingBookingDTO> getItTrainingBookingById(@RequestParam Integer itTrainingBookingId) {
        try {
            ResponseSingleItTrainingBookingDTO responseSingleItTrainingBookingDTO = new ResponseSingleItTrainingBookingDTO("success", "IT Training not found");

            ItTrianningBookingDto itTrianningBookingDto= itTrainingBookingService.GetbyId(itTrainingBookingId);
            responseSingleItTrainingBookingDTO.setObject(itTrianningBookingDto);
           return ResponseEntity.status(HttpStatus.OK).body(responseSingleItTrainingBookingDTO);
        } catch (ItTrainingBookingException itTrainingBookingException)
        {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseSingleItTrainingBookingDTO("unsucces","IT Training not found")));
        }
    }
}
