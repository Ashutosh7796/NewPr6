package com.example.Project06.Controller;

import com.example.Project06.Dto.*;
import com.example.Project06.Service.BlogService;
import com.example.Project06.exception.*;
import com.example.Project06.utils.BaseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Blogs")
@RequiredArgsConstructor
public class BlogController {


    private final BlogService blogService;

    @PostMapping(value = "/addBlog")
    public ResponseEntity<BaseResponseDTO> addEvent(@RequestBody BlogDto blogDto, Integer userId) {
        try {
            String response = blogService.AddBlog(blogDto, userId);
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseDTO("Success", response));
        } catch (UserNotFoundExceptions e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful", e.getMessage()));
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getBlogById(@RequestParam Integer blogId) {
        try {
            SingleBlogDto responseDto = new SingleBlogDto("Success");
            responseDto.setResponse(blogService.getBlogById(blogId));
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (BlogNotFoundException e) {
            BlogUpdateDto userupdateDTO = new BlogUpdateDto("Unsuccess");
            userupdateDTO.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userupdateDTO);

        }
    }

    @GetMapping("/getAllBlogs")
    public ResponseEntity<ResponseAllBlogDto> getAllBlogs(@RequestParam int pageNo,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            List<GetSingleBlogDto> allBlogs = blogService.getAllBlogs(pageNo, pageSize);
            ResponseAllBlogDto responseAllCompnayDto = new ResponseAllBlogDto("Success");
            responseAllCompnayDto.setList(allBlogs);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllCompnayDto);
        } catch (PageNotFoundException e) {
            ResponseAllBlogDto dto = new ResponseAllBlogDto("Unsuccess");
            dto.setException("Page Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }

    @PatchMapping("/updateBlogDetails")
    public ResponseEntity<?> updateDetails(@RequestBody GetSingleBlogDto blogDto) {
        try {
            blogService.updateDetails(blogDto);
            BlogUpdateDto userupdateDTO = new BlogUpdateDto("success");
            userupdateDTO.setMessage("Blog Details Updated Successfully");

            return ResponseEntity.status(HttpStatus.OK).body(userupdateDTO);
        } catch (BlogNotFoundException e) {
            BlogUpdateDto userupdateDTO = new BlogUpdateDto("Unsuccess");
            userupdateDTO.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userupdateDTO);

        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam Integer blogId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", blogService.deleteById(blogId)));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        }
    }

    @GetMapping("/getByUserId")
    public ResponseEntity<?> getBlogByUserId(@RequestParam Integer userId) {
        try {
            List<GetSingleBlogDto> blogDtos = blogService.getBlogByUserId(userId);

            if (blogDtos.isEmpty()) {
                ResponseAllBlogDto responseDto = new ResponseAllBlogDto("No blogs found for the given user ID");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);

            } else {
                ResponseAllBlogDto responseDto = new ResponseAllBlogDto("Success");
                responseDto.setList(blogDtos);
                return ResponseEntity.status(HttpStatus.OK).body(responseDto);
            }
        } catch (BlogNotFoundException e) {
            ResponseAllBlogDto responseDto = new ResponseAllBlogDto("Unsuccessful");
            responseDto.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
        }
    }
}
