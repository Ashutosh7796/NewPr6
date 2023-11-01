package com.example.Project06.Controller;

import com.example.Project06.Dto.ItTraining.ItTrainingDTO;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.ItTrainingService;
import com.example.Project06.exception.ItTrainingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
