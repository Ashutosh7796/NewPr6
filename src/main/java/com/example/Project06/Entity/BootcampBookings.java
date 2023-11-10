package com.example.Project06.Entity;

import com.example.Project06.Dto.BootcampBookingsDto.BootcampBookingsDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Table(name = "BootcampBookingses")
@Getter
@Setter
@NoArgsConstructor
public class BootcampBookings {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bootcampBookingsId;

    @Column
    private OffsetDateTime date;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_bootcamp_id", nullable = false)
    private Bootcamp bootcampBootcamp;

    public BootcampBookings(BootcampBookingsDto bootcampBookingsDto) {
        this.date = bootcampBookingsDto.getDate();
        this.userId = bootcampBookingsDto.getBootcampBootcampID();
        this.status = bootcampBookingsDto.getStatus();
    }
}
