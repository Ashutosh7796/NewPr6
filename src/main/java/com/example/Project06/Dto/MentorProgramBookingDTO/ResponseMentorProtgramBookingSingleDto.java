package com.example.Project06.Dto.MentorProgramBookingDTO;

import com.example.Project06.Entity.Mentor;
import lombok.Data;

@Data
public class ResponseMentorSingleDto {
    private String status;
    private Mentor response;

    public ResponseMentorSingleDto(String status) {
        this.status = status;
    }
}
