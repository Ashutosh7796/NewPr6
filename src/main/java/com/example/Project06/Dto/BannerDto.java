package com.example.Project06.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
@Data
public class BannerDto {

    private String name;

    private String status;

    private String taital;

    private String bannerLink;
}
