package com.example.Project06.Dto;

import lombok.Data;
import java.util.List;

@Data
public class ResponseAllBlogDto {

    private String message;
    private List<GetSingleBlogDto> list;
    private String exception;

    public ResponseAllBlogDto(String message){
        this.message=message;
    }
}
