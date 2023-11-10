package com.example.Project06.ServiceImpl;


import com.example.Project06.Dto.EduSuggest.EduSuggestDto;
import com.example.Project06.Entity.EduSuggestion;
import com.example.Project06.Repository.EduSuggestRepo;
import com.example.Project06.Service.EduSuggest;
import com.example.Project06.exception.UniversityDataNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EduSuggestServiceImpl implements EduSuggest {

    private final EduSuggestRepo eduSuggestRepo;

    public List<EduSuggestDto> getSuggestions(String userInput, String education) {

        List<EduSuggestion> suggestions = eduSuggestRepo.findByBoardUniversityContainingOrEducationContaining(userInput, education);

        System.out.println("Number of suggestions retrieved: " + suggestions.size());

        if(suggestions.isEmpty()) {
            throw new UniversityDataNotFound("Opps!!! No Matching Record Found", HttpStatus.NOT_FOUND);
        }

        return suggestions.stream()
                .map(suggestion -> {
                    EduSuggestDto dto = new EduSuggestDto();
                    dto.setBoard_University(suggestion.getBoardUniversity());
                    dto.setEducation(suggestion.getEducation());
                    return dto;
                })
                .collect(Collectors.toList());

    }
}

