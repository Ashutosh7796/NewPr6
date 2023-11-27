package com.example.Project06.Dto.HrCall;

import com.example.Project06.Entity.HrCall;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class HrCallDto {

    private Integer userId;

    private LocalDate date;

    private LocalTime time;

    private String position;

    private String status;

    private String response;

    public HrCallDto(HrCall hrCall) {
        this.userId = hrCall.getUserId();
        this.date = hrCall.getDate();
        this.time = hrCall.getTime();
        this.position = hrCall.getPosition();
        this.status = hrCall.getStatus();
        this.response = hrCall.getRespond();
    }
}
