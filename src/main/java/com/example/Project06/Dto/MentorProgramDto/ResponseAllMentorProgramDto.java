package com.example.Project06.Dto.MentorProgramDto;

import com.example.Project06.Entity.Mentor;
import com.example.Project06.Entity.MentorProgram;
import lombok.Data;

import java.util.List;
@Data
public class ResponseAllMentorProgramDto {
    private String status;
    private List<MentorProgram> response;

    public ResponseAllMentorProgramDto(String status) {
        this.status = status;
    }
}
