package com.example.Project06.Entity;

import com.example.Project06.Dto.ItTraining.ItTrainingDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "ItTrainings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItTraining {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itTrainingId;

    @Column(length = 100)
    private String domain;

    @Column(length = 45)
    private String mode;

    @Column(length = 100)
    private String mentor;

    @Column(length = 45)
    private String cost;

    @Column(length = 45)
    private String topic;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column(length = 45)
    private String duration;




    public ItTraining(ItTrainingDTO itTrainingDTO) {
        this.itTrainingId = itTrainingDTO.getItTrainingId();
        this.domain = itTrainingDTO.getDomain();
        this.mode = itTrainingDTO.getMode();
        this.mentor = itTrainingDTO.getMentor();
        this.cost = itTrainingDTO.getCost();
        this.topic = itTrainingDTO.getTopic();
        this.startDate = itTrainingDTO.getStartDate();
        this.endDate = itTrainingDTO.getEndDate();
        this.duration = itTrainingDTO.getDuration();

    }
}
