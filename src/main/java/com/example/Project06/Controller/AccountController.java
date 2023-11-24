package com.example.Project06.Controller;

import com.example.Project06.Dto.RegisterDto;
import com.example.Project06.Service.UserService;
import com.example.Project06.exception.*;
import com.example.Project06.utils.BaseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponseDTO> register(@RequestBody RegisterDto registerDto){

        try {
           BaseResponseDTO response= userService.registerAccount(registerDto);
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseDTO("Successful",response.getMessage()));
        }catch (UserAlreadyExistException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful","User with Email already exists"));
        }catch (BaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful","Invalid role"));
        }catch (DuplicateGSTNumberException e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccess", "The Gst no Already Exist"));
        }catch (InvalidHRRegistrationException e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccess", e.getMessage()));
        }catch (EmailNotVerifiedException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("UnSuccessful", "Email not verified"));
        }
    }
}
