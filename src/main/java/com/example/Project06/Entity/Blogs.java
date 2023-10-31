package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Blogses")
@Getter
@Setter
public class Blogs {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogsId;

    @Column
    private Integer userId;

    @Column(length = 250)
    private String blog;

}
