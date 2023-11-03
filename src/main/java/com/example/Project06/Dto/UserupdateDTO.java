package com.example.Project06.Dto;


import lombok.Data;

@Data
public class UserupdateDTO {
   private String status;
    private String exception;
    private String message;

    public UserupdateDTO(String message) {
        this.status = message;
    }
}
