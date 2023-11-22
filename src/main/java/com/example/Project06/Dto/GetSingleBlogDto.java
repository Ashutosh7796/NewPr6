package com.example.Project06.Dto;

import com.example.Project06.Entity.Blogs;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class GetSingleBlogDto {

    private Integer blogId;

    private Integer userId;

    private String blog;

    public GetSingleBlogDto(Blogs blogs) {
        this.blog = blogs.getBlog();
        this.userId=blogs.getUserId();
        this.blogId=blogs.getBlogsId();
    }
}
