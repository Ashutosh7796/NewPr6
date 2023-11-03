package com.example.Project06.Dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseAllUsersDto {

    private String message;
    private List<GetAllUserDTO> list;
    private String exception;

    public ResponseAllUsersDto(String message){
        this.message=message;
    }

}
