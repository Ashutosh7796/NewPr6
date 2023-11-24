package com.example.Project06.Dto.Event;

import lombok.Data;
@Data
public class EventUpdateDto {

        private String status;
        private String exception;
        private String message;

        public EventUpdateDto(String message) {
            this.status = message;
        }
    }


