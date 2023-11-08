package com.example.Project06.Service;

import com.example.Project06.Dto.EduSuggest.EduSuggestDto;

import java.util.List;

public interface EduSuggest {

    List<EduSuggestDto> getSuggestions(String userInput, String education);

}
