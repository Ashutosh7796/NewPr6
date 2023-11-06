package com.example.Project06.Dto.ItTrianningBooking;

import com.example.Project06.Entity.ItTraining;
import com.example.Project06.Entity.ItTrainingBooking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.sql.Time;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@ToString
@Builder
public class ItTrianningBookingDto {

    private Integer itTrainingBookingId;

    private Integer userId;

    private String status;

    private LocalDate date;


    private String ItTrainingId;

    public ItTrianningBookingDto(ItTrainingBooking itTrainingBooking) {
        this.itTrainingBookingId = itTrainingBooking.getItTrainingBookingId();
        this.userId = itTrainingBooking.getUserId();
        this.status = itTrainingBooking.getStatus();
        this.date = itTrainingBooking.getDate();
        this.ItTrainingId = itTrainingBooking.getItTrainingId();
    }
}
