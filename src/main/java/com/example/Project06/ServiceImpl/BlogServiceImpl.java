package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.BlogDto;
import com.example.Project06.Dto.Event.GetSingleEventDto;
import com.example.Project06.Dto.GetSingleBlogDto;
import com.example.Project06.Entity.Blogs;
import com.example.Project06.Entity.Events;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.BlogRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.BlogService;
import com.example.Project06.exception.BlogNotFoundException;
import com.example.Project06.exception.EventNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepo blogRepo;

    private final UserRepository userRepository;

    @Override
    public String AddBlog(BlogDto blogDto, Integer userId) {
        Blogs Blog = new Blogs (blogDto);
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Blogs blog = new Blogs(blogDto);
            blog.setUserId(userId);
            blogRepo.save(blog);
            return "Blog Added Successfully";
        } else {
            throw new UserNotFoundExceptions("User not found with ID: " + userId);
        }
    }

    @Override
    public GetSingleBlogDto getBlogById(Integer blogId) {
        Optional<Blogs> blog = blogRepo.findById(blogId);

        if(blog.isEmpty())
        {
            throw new BlogNotFoundException("Blog Not Found by id ");
        }
        GetSingleBlogDto blogDto = new GetSingleBlogDto(blog.get());
        return blogDto;
    }

    @Override
    public List<GetSingleBlogDto> getBlogByUserId(Integer userId) {
        List<Blogs> blogs = blogRepo.findByuserId(userId);

        if (blogs.isEmpty()) {
            throw new BlogNotFoundException("Blogs Not Found by user id ");
        }

        return blogs.stream()
                .map(GetSingleBlogDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetSingleBlogDto> getAllBlogs(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Blogs> allblogs = blogRepo.findAll(pageable);

        List<GetSingleBlogDto> getAllBlogs = new ArrayList<>();

        for (Blogs blogs : allblogs) {
            GetSingleBlogDto blogDto = convertToDto(blogs);
            getAllBlogs.add(blogDto);
        }

        return getAllBlogs;
    }

    @Override
    public void updateDetails(GetSingleBlogDto blogDto) {
        Blogs blog = blogRepo.findById(blogDto.getBlogId()).orElseThrow(()-> new BlogNotFoundException("Blog Not Found", HttpStatus.NOT_FOUND));
        if (blogDto.getBlog() != null){
            blog.setBlog(blogDto.getBlog());
        }
        blogRepo.save(blog);
    }

    @Override
    public String deleteById(Integer blogId) {
        blogRepo.findById(blogId).orElseThrow(() -> new RuntimeException("Blog details Not found By Id"));
        blogRepo.deleteById(blogId);
        return "Blog deleted Successfully ";
    }

    private GetSingleBlogDto convertToDto(Blogs blogs ) {
        GetSingleBlogDto blogDto = new GetSingleBlogDto();
        blogDto.setBlogId(blogs.getBlogsId());
        blogDto.setUserId(blogs.getUserId());
        blogDto.setBlog(blogs.getBlog());

        return blogDto;
    }

}
