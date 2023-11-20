package com.example.Project06.Dto.MentorProfileDto;

import com.example.Project06.Entity.Mentor;
import lombok.Data;

import java.util.List;
@Data
public class ResponseAllMentorDto {
    private String status;
    private List<Mentor> response;

    public ResponseAllMentorDto(String status) {
        this.status = status;
    }
}
