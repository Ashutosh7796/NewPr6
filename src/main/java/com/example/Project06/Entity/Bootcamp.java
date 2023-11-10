package com.example.Project06.Entity;

import com.example.Project06.Dto.BootcampDto.BootcampDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Bootcamps")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bootcamp {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bootcampId;

    @Column(length = 200)
    private String bootcampTital;

    @Column(length = 250)
    private String bootcampDetails;

    @Column
    private LocalDate date;

    @Column
    private LocalDate bootcampDate;

    @Column(length = 45)
    private String time;

    @Column(length = 45)
    private String status;

    @Column(length = 45)
    private String location;

    @Column(length = 45)
    private String tagLine;

    @Column(length = 45)
    private String photo;

    @Column(length = 45)
    private String price;

    @OneToMany(mappedBy = "bootcampBootcamp")
    private Set<BootcampBookings> bootcampBootcampBootcampBookingses;
    public Bootcamp(BootcampDto bootcampDto) {

        this.bootcampTital = bootcampDto.getBootcampTital();
        this.bootcampDetails = bootcampDto.getBootcampDetails();
        this.date = bootcampDto.getDate();
        this.bootcampDate = bootcampDto.getBootcampDate();
        this.time = bootcampDto.getTime();
        this.status = bootcampDto.getStatus();
        this.location = bootcampDto.getLocation();
        this.tagLine = bootcampDto.getTagLine();
        this.photo = bootcampDto.getPhoto();
        this.price = bootcampDto.getPrice();
    }
}
