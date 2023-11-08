package com.example.Project06.Dto.EduSuggest;

import lombok.Data;

import java.util.List;

@Data
public class ResponseEducationDto {

        private String message;
        private List<EduSuggestDto> list;
        private String exception;

        public ResponseEducationDto(String message) {
            this.message = message;
        }
    }



