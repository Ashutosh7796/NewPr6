package com.example.Project06.Dto.HrCall;

import com.example.Project06.Entity.HrCall;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
public class GetSingleHrCallDto {

        private Integer hrCallId;

        private Integer hrId;

        private Integer userId;

        private LocalDate date;

        private LocalTime time;

        private String position;

        private String status;

        private String respond;

        public GetSingleHrCallDto(HrCall hrCall) {
            this.hrCallId = hrCall.getHrCallId();
            this.userId = hrCall.getUserId();
            this.date = hrCall.getDate();
            this.time = hrCall.getTime();
            this.position = hrCall.getPosition();
            this.status = hrCall.getStatus();
            this.respond = hrCall.getRespond();
            this.hrId = hrCall.getHrHr().getHrId();
        }
    }


