package com.example.Project06.Dto.Event;

import com.example.Project06.Dto.GetSingleUserDto;
import lombok.Data;

@Data
public class SingleEventDto {


        private String status;
        private GetSingleEventDto Response;

        public SingleEventDto(String status) {
            this.status = status;
        }


    }

