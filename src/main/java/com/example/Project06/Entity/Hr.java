package com.example.Project06.Entity;

import com.example.Project06.Dto.hr.HrDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "Hrs")
@Getter
@Setter
public class Hr {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hrId;

    @Column(length = 45)
    private String designation;

    @Column(length = 45)
    private String Hrstatus;

    @Column(length = 45)
    private String refNoOfCompany;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_company_id", nullable = false)
    private Company companyCompany;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;

    @OneToMany(mappedBy = "hrHr")
    private Set<HrCall> hrHrHrCalls;

    public Hr() {
    }

    public Hr(HrDto hrDto) {
       this.designation = hrDto.getDigignastion();
        this.Hrstatus = hrDto.getStatus();
        this.refNoOfCompany = hrDto.getRefNoOfCompany();

    }
}
