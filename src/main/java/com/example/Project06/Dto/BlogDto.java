package com.example.Project06.Dto;

import com.example.Project06.Entity.Blogs;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogDto {


    private String blog;

    public BlogDto(Blogs blogs) {
        this.blog = blogs.getBlog();
    }
}
