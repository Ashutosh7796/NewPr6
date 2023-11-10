package com.example.Project06.Controller;
import com.example.Project06.Dto.EduSuggest.EduSuggestDto;
import com.example.Project06.Dto.EduSuggest.ResponseEducationDto;
import com.example.Project06.Service.EduSuggest;
import com.example.Project06.exception.UniversityDataNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("ESuggest")
public class EduSuggetionController {

    private final EduSuggest eduSuggest;

    @GetMapping("/get-suggestions")
    public ResponseEntity<?> getSuggestions(@RequestParam String userInput, @RequestParam String education) {
        try {
            List<EduSuggestDto> suggestions = eduSuggest.getSuggestions(userInput, education);
            ResponseEducationDto responseEducationDto = new ResponseEducationDto("Success");
            responseEducationDto.setList(suggestions);
            return ResponseEntity.status(HttpStatus.OK).body(responseEducationDto);
        }catch (UniversityDataNotFound e) {
            ResponseEducationDto responseEducationDto = new ResponseEducationDto("Unsuccess");
            responseEducationDto.setException(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseEducationDto);
        }



    }

}
