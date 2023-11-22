package com.example.Project06.Service;

import com.example.Project06.Dto.BlogDto;
import com.example.Project06.Dto.GetSingleBlogDto;

import java.util.List;

public interface BlogService {
    String AddBlog(BlogDto blogDto, Integer userId);

    public GetSingleBlogDto getBlogById(Integer blogId);

   List <GetSingleBlogDto> getBlogByUserId(Integer userId);

    List<GetSingleBlogDto> getAllBlogs(int pageNo, int pageSize);

    public void updateDetails (GetSingleBlogDto blogDto);
    public String deleteById(Integer blogId);

}
