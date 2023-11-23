package com.example.Project06.Dto;

import com.example.Project06.Dto.Event.GetSingleEventDto;
import lombok.Data;
@Data
public class SingleBlogDto {


        private String status;
        private GetSingleBlogDto Response;

        public SingleBlogDto(String status) {
            this.status = status;
        }


    }

