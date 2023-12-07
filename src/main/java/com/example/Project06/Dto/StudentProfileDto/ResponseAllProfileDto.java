package com.example.Project06.Dto.StudentProfileDto;

import com.example.Project06.Dto.HrCall.GetSingleHrCallDto;
import lombok.Data;
import java.util.List;
@Data
public class ResponseAllProfileDto {


        private String message;
        private List<GetSingleProfileDto> list;
        private String exception;

        public ResponseAllProfileDto(String message){
            this.message=message;
        }
    }



