package com.example.Project06.Dto;

import lombok.Data;
@Data
public class BlogUpdateDto {

        private String status;
        private String exception;
        private String message;

        public BlogUpdateDto(String message) {
            this.status = message;
        }
    }



