package com.example.Project06.Dto.liveProjectBooking;

import com.example.Project06.Entity.LiveProjectBooking;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
@Data
public class LiveProjectBookingDto {

    private Integer liveProjectBookingId;

    private LocalDate date;

    private String status;

    private String userId;

    private Integer liveProjectID;

    public LiveProjectBookingDto() {
    }

    public LiveProjectBookingDto(LiveProjectBooking liveProjectBooking) {
        this.liveProjectBookingId = liveProjectBooking.getLiveProjectBookingId();
        this.date = liveProjectBooking.getDate();
        this.status = liveProjectBooking.getStatus();
        this.userId = liveProjectBooking.getUserId();
        this.liveProjectID = liveProjectBooking.getLiveProjectID();
    }
}
