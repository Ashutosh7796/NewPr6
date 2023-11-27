package com.example.Project06.Entity;

import com.example.Project06.Dto.HrCall.HrCallDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "HrCalls")
@Getter
@Setter
@NoArgsConstructor
public class HrCall {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hrCallId;

    @Column
    private Integer userId;

    @Column
    private LocalDate date;

    @Column
    private LocalTime time;

    @Column(length = 45)
    private String position;

    @Column(length = 45)
    private String status;

    @Column(length = 45)
    private String respond;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hr_hr_id", nullable = false)
    private Hr hrHr;

    public HrCall(HrCallDto hrCallDto) {
        this.userId = hrCallDto.getUserId();
        this.date = hrCallDto.getDate();
        this.time = hrCallDto.getTime();
        this.position = hrCallDto.getPosition();
        this.status = hrCallDto.getStatus();
        this.respond = hrCallDto.getResponse();
    }
}
