package com.example.Project06.Dto;

import com.example.Project06.Entity.User;
import lombok.Data;

import java.util.List;

@Data
public class ResponseAllUsersDto {

    private String message;
    private List<RegisterDto> list;
    private String exception;

    public ResponseAllUsersDto(String message){
        this.message=message;
    }

}
