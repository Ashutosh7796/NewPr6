package com.example.Project06.Controller;

import com.example.Project06.Dto.ItTraining.ResponceAllItTrainDto;
import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import com.example.Project06.Dto.ItTrianningBooking.ResponseAllItTrainingBookingDTO;
import com.example.Project06.Dto.ItTrianningBooking.ResponseSingleItTrainingBookingDTO;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.ItTrainingBookingService;
import com.example.Project06.exception.ItTrainingBookingException;
import com.example.Project06.exception.ItTrainingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        catch (ItTrainingNotFoundException itTrainingNotFoundException)
        {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsucces","IT Training not found")));
        }
    }

    @GetMapping("/ById")
    public ResponseEntity<ResponseSingleItTrainingBookingDTO> getItTrainingBookingById(@RequestParam Integer itTrainingBookingId) {
        try {
            ResponseSingleItTrainingBookingDTO responseSingleItTrainingBookingDTO = new ResponseSingleItTrainingBookingDTO("success");

            ItTrianningBookingDto itTrianningBookingDto= itTrainingBookingService.GetbyId(itTrainingBookingId);
            responseSingleItTrainingBookingDTO.setObject(itTrianningBookingDto);
           return ResponseEntity.status(HttpStatus.OK).body(responseSingleItTrainingBookingDTO);
        } catch (ItTrainingBookingException itTrainingBookingException)
        {
            ResponseSingleItTrainingBookingDTO responseSingleItTrainingBookingDTO = new ResponseSingleItTrainingBookingDTO("unsuccess");
            responseSingleItTrainingBookingDTO.setException("booking not found");
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseSingleItTrainingBookingDTO));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseAllItTrainingBookingDTO> getAllItTrainingBookings() {
        try {
            ResponseAllItTrainingBookingDTO responseAllItTrainingBookingDTO = new ResponseAllItTrainingBookingDTO("success");
            List<ItTrianningBookingDto> itTrianningBookinglist = itTrainingBookingService.AllItBooking();
            responseAllItTrainingBookingDTO.setList(itTrianningBookinglist);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllItTrainingBookingDTO);
        } catch (ItTrainingBookingException itTrainingBookingException) {
            ResponseAllItTrainingBookingDTO responseAllItTrainingBookingDTO = new ResponseAllItTrainingBookingDTO("success");
            responseAllItTrainingBookingDTO.setException("IT Training booking not found");
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllItTrainingBookingDTO));

        }
    }

    @GetMapping("/ByItTrainingId")
    public ResponseEntity<ResponceAllItTrainDto> getAllItTrainingBookingsByItTrainingId(@RequestParam Integer itTrainingId) {
        try {
            ResponceAllItTrainDto responseAllItTrainingBookingDTO = new ResponceAllItTrainDto("success");

            List<ItTrianningBookingDto> itTrainingBookings = itTrainingBookingService.getAllByItTrainingId(itTrainingId);
            responseAllItTrainingBookingDTO.setObjects(itTrainingBookings);

            return ResponseEntity.status(HttpStatus.OK).body(responseAllItTrainingBookingDTO);
        } catch (ItTrainingBookingException itTrainingBookingException) {
            ResponceAllItTrainDto responseAllItTrainingBookingDTO = new ResponceAllItTrainDto("unsuccess");
            responseAllItTrainingBookingDTO.setException("bookings not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllItTrainingBookingDTO);
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteItTrainingBooking(@RequestParam Integer itTrainingBookingId) {
        try {
            String result = itTrainingBookingService.ItBookingDelete(itTrainingBookingId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (ItTrainingBookingException itTrainingBookingException) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "IT Training booking not found"));
        }
    }

    @GetMapping("/byUserId")
    public ResponseEntity<ResponseAllItTrainingBookingDTO> getItTrainingBookingsByUserId(@RequestParam Integer userId) {
        try {
            ResponseAllItTrainingBookingDTO responseAllItTrainingBookingDTO = new ResponseAllItTrainingBookingDTO ("success");
             List<ItTrianningBookingDto> itTrainingBookings = itTrainingBookingService.getByUserId(userId);
             responseAllItTrainingBookingDTO.setList(itTrainingBookings);
             return ResponseEntity.status(HttpStatus.OK).body(responseAllItTrainingBookingDTO);
    } catch (ItTrainingBookingException itTrainingBookingException){
            ResponseAllItTrainingBookingDTO responseAllItTrainingBookingDTO = new ResponseAllItTrainingBookingDTO("success");
            responseAllItTrainingBookingDTO.setException("IT Training booking not found");
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllItTrainingBookingDTO));
        }
    }





}
