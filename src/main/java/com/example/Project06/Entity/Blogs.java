package com.example.Project06.Entity;

import com.example.Project06.Dto.BlogDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Blogses")
@Getter
@Setter
@NoArgsConstructor
public class Blogs {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogsId;

    @Column
    private Integer userId;

    @Column(length = 250)
    private String blog;

    public Blogs(BlogDto blogDto) {
        this.blog = blogDto.getBlog();
    }
}
