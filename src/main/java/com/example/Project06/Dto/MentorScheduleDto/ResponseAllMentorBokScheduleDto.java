package com.example.Project06.Dto.MentorScheduleDto;

import com.example.Project06.Entity.MentorBokSchedule;
import lombok.Data;

import java.util.List;
@Data
public class ResponseAllMentorBokScheduleDto {
    private String status;
    private List<MentorBokSchedule> response;

    public ResponseAllMentorBokScheduleDto(String status) {
        this.status = status;
    }
}
