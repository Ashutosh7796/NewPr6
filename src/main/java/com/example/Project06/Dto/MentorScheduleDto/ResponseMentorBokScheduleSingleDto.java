package com.example.Project06.Dto.MentorScheduleDto;

import com.example.Project06.Entity.MentorBokSchedule;
import lombok.Data;

@Data
public class ResponseMentorBokScheduleSingleDto {
    private String status;
    private MentorBokSchedule response;

    public ResponseMentorBokScheduleSingleDto(String status) {
        this.status = status;
    }
}
