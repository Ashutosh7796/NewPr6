package com.example.Project06.Controller;

import com.example.Project06.Dto.PasswordChange;
import com.example.Project06.Dto.RegisterDto;
import com.example.Project06.Dto.ResponseAllUsersDto;
import com.example.Project06.Service.UserService;
import com.example.Project06.exception.InvalidPasswordException;
import com.example.Project06.exception.PageNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import com.example.Project06.utils.BaseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/index")
    public ResponseEntity<String> index(Principal principal){
        return ResponseEntity.ok("Welcome to user page : " + principal.getName());
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editUser(@RequestBody RegisterDto userProfileDto, @PathVariable int id){

        try {
            BaseResponseDTO result = userService.editUser(userProfileDto,id);
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseDTO("Successful",result.getMessage()));
        }catch (UserNotFoundExceptions exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponseDTO("Unsuccessful","user not found"));
        }
    }



    @PutMapping("/changePassword/{id}")
    public ResponseEntity<BaseResponseDTO> changePassword(@PathVariable int id, @RequestBody PasswordChange passwordChange){

        try{
            BaseResponseDTO result =userService.changePassword(id,passwordChange);
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseDTO("Successful",result.getMessage()));
        }catch (UserNotFoundExceptions exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponseDTO("Unsuccessfully","UserNotFoundException"));
        } catch (InvalidPasswordException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponseDTO("Unsuccessfully","InvalidPasswordException"));
        }
    }



}
