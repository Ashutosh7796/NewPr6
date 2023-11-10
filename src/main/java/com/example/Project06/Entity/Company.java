package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "Companies")
@Getter
@Setter
public class Company {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    @Column(length = 250)
    private String companyName;

    @Column(length = 250)
    private String gestnNo;

    @Column(length = 250)
    private String companyServices;

    @Column(length = 250)
    private String companyType;

    @Column(length = 45)
    private String companyLevel;

    @Column(length = 250)
    private String logo;

    @Column(length = 250)
    private String officeAddress;

    @Column(length = 250)
    private String companyLocations;

    @Column(length = 250)
    private String oneCopmpanyDoc;

    @Column(length = 45)
    private String refNo;

    @Column(length = 45)
    private String CompanyStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;

    @OneToMany(mappedBy = "companyCompany",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Hr> companyCompanyHrs;

}
