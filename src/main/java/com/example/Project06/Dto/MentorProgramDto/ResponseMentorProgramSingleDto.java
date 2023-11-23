package com.example.Project06.Dto.MentorProgramDto;

import com.example.Project06.Entity.MentorProgram;
import lombok.Data;

@Data
public class ResponseMentorProgramSingleDto {
    private String status;
    private MentorProgram response;

    public ResponseMentorProgramSingleDto(String status) {
        this.status = status;
    }
}
