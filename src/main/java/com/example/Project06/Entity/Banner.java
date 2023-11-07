package com.example.Project06.Entity;

import com.example.Project06.Dto.BannerDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "Banners")
@Getter
@Setter
@NoArgsConstructor
public class Banner {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bannerId;

    @Column(length = 45)
    private String name;

    @Column
    private LocalDate date;

    @Column(length = 45)
    private String status;

    @Column(length = 45)
    private String taital;

    @Column(length = 250)
    private String bannerLink;
    public Banner(BannerDto bannerDto) {

        this.name = bannerDto.getName();
        this.date = LocalDate.now();
        this.status = bannerDto.getStatus();
        this.taital = bannerDto.getTaital();
        this.bannerLink = bannerDto.getBannerLink();
    }
}
