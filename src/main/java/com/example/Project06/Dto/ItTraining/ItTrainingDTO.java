package com.example.Project06.Dto.ItTraining;

import com.example.Project06.Entity.ItTraining;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@ToString
@Builder
public class ItTrainingDTO {

    private Integer itTrainingId;

    private String domain;


    private String mode;


    private String mentor;


    private String cost;


    private String topic;


    private LocalDate startDate;


    private LocalDate endDate;


    private String duration;


    public ItTrainingDTO(ItTraining itTraining) {
        this.itTrainingId = itTraining.getItTrainingId();
        this.domain = itTraining.getDomain();
        this.mode = itTraining.getMode();
        this.mentor = itTraining.getMentor();
        this.cost = itTraining.getCost();
        this.topic = itTraining.getTopic();
        this.startDate = itTraining.getStartDate();
        this.endDate = itTraining.getEndDate();
        this.duration = itTraining.getDuration();
    }
}
