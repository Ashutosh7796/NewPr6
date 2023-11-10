package com.example.Project06.Controller;

import com.example.Project06.Dto.ItTraining.ItTrainingDTO;
import com.example.Project06.Dto.ItTraining.ResponseAllItTrainingDTO;
import com.example.Project06.Dto.ItTraining.ResponseSingleItTrainingDTO;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.ItTrainingService;
import com.example.Project06.exception.ItTrainingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ItTraining")
public class ItTrainingController {

    private final ItTrainingService itTrainingService;
@PostMapping("/add")
    public ResponseEntity<ResponseDto> ItTrainingadd(@RequestBody ItTrainingDTO itTrainingDTO)
    {
        try {
            String result = itTrainingService.AddItTraining(itTrainingDTO);
            return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",result)));
        }catch (ItTrainingNotFoundException itTrainingNotFoundException)
        {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsucces","IT Training not found")));
        }
    }
 @GetMapping("/byID")
 public ResponseEntity<ResponseSingleItTrainingDTO> ItTrainingById(@RequestParam Integer itTrainingId){
    try {
        ResponseSingleItTrainingDTO responseSingleItTrainingDTO = new ResponseSingleItTrainingDTO("success");
        ItTrainingDTO itTraining = itTrainingService.GetById(itTrainingId);
        responseSingleItTrainingDTO.setObject(itTraining);
        return ResponseEntity.status(HttpStatus.OK).body(responseSingleItTrainingDTO);

    }catch (ItTrainingNotFoundException itTrainingNotFoundException)
    {
        ResponseSingleItTrainingDTO responseSingleItTrainingDTO = new ResponseSingleItTrainingDTO("unsuccessful");
        responseSingleItTrainingDTO.setException("IT Training not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseSingleItTrainingDTO);
    }
 }

    @GetMapping("/all")
    public ResponseEntity<ResponseAllItTrainingDTO> getAllItTraining() {
        try {
            ResponseAllItTrainingDTO responseAllItTrainingDTO = new ResponseAllItTrainingDTO("success");
            List<ItTrainingDTO> itTrainingList = itTrainingService.GetAllitTraining();
            responseAllItTrainingDTO.setList(itTrainingList);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllItTrainingDTO);
        }catch (ItTrainingNotFoundException itTrainingNotFoundException)
        {
            ResponseAllItTrainingDTO responseAllItTrainingDTO = new ResponseAllItTrainingDTO("unsuccessful");
            responseAllItTrainingDTO.setException("IT Training not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllItTrainingDTO);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteItTraining(@RequestParam Integer itTrainingId) {
        try {
            String result = itTrainingService.deleteItTraining(itTrainingId);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (ItTrainingNotFoundException itTrainingNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsucces", "IT Training not found"));
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<ResponseDto> UpdateItTraining(@RequestBody ItTrainingDTO itTrainingDTO,@RequestParam Integer itTrainingId){
    try {
        String result = itTrainingService.EditItTraining(itTrainingDTO,itTrainingId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
    }
    catch (ItTrainingNotFoundException itTrainingNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "it Training Not found"));
    }
    }
}
