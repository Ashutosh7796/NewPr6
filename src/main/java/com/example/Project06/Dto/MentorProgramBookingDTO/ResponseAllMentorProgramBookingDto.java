package com.example.Project06.Dto.MentorProgramBookingDTO;

import com.example.Project06.Entity.Mentor;
import com.example.Project06.Entity.MentorProgramBookings;
import lombok.Data;

import java.util.List;
@Data
public class ResponseAllMentorProgramBookingDto {
    private String status;
    private List<MentorProgramBookings> response;

    public ResponseAllMentorProgramBookingDto(String status) {
        this.status = status;
    }
}
