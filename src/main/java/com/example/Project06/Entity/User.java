package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_id_generator")
    @SequenceGenerator(name = "user_id_generator", initialValue = 1000)
    private Integer id;

    @Column(nullable = false, length = 250)
    private String fullName;

    @Column(nullable = false, length = 250)
    private String email;

    @Column(nullable = false, length = 45)
    private String moNumber;

    @Column(nullable = false, length = 250)
    private String password;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @Column(length = 45)
    private String status;

    @Column
    private LocalDate date;

    @Column(length = 45)
    private String ref;

    @Column(length = 45)
    private String gender;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "userUser")
    private Set<Job> userUserJobs;

    @OneToMany(mappedBy = "userUser")
    private Set<StudentProfile> userUserStudentProfiles;

    @OneToMany(mappedBy = "userUser")
    private Set<Company> userUserCompanies;

    @OneToMany(mappedBy = "userUser")
    private Set<Hr> userUserHrs;

    @OneToMany(mappedBy = "userUser")
    private Set<StudentApplications> userUserStudentApplicationses;

    @OneToMany(mappedBy = "userUser")
    private Set<Documents> userUserDocumentses;

    @OneToMany(mappedBy = "userUser")
    private Set<PlatformResume> userUserPlatformResumes;

    @OneToMany(mappedBy = "userUser")
    private Set<Tpo> userUserTpoes;

    @OneToMany(mappedBy = "userUser")
    private Set<Feedback> userUserFeedbacks;

    @OneToMany(mappedBy = "userUser")
    private Set<Mentor> userUserMentors;

    @OneToMany(mappedBy = "userUser")
    private Set<MentorBokSchedule> userUserMentorBokSchedules;

}
