package com.example.Project06.Dto.Planning;

import com.example.Project06.Entity.CareerPlanning;
import com.example.Project06.Entity.Hr;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.OffsetDateTime;
@Data
public class CareerPlaningDto {

    private String domain;

    private String mode;


    private OffsetDateTime slot;


    private String cost;


    private Integer userId;

    private String status;


    public CareerPlaningDto() {
    }

    public CareerPlaningDto(CareerPlanning careerPlanning){
        this.domain= careerPlanning.getDomain();
        this.mode= careerPlanning.getMode();
        this.slot=careerPlanning.getSlot();
        this.cost= careerPlanning.getCost();
        this.userId= careerPlanning.getUserId();
        this.status= careerPlanning.getStatus();
    }

}
