package com.example.Project06.Dto.MentorProgramBookingDTO;

import com.example.Project06.Entity.MentorProgramBookings;
import lombok.Data;

@Data
public class ResponseMentorProtgramBookingSingleDto {
    private String status;
    private MentorProgramBookings response;

    public ResponseMentorProtgramBookingSingleDto(String status) {
        this.status = status;
    }
}
