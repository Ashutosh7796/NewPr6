package com.example.Project06.Dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseAllCompnayDto {


        private String message;
        private List<GetAllCompanies> list;
        private String exception;

        public ResponseAllCompnayDto(String message){
            this.message=message;
        }

    }


