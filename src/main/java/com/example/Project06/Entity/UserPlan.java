package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "UserPlans")
@Getter
@Setter
public class UserPlan {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userPlanId;

    @Column
    private Integer userId;

    @Column
    private Integer planId;

    @Column
    private Integer payId;

    @Column(length = 45)
    private String status;

}
