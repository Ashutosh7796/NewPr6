package com.example.Project06.Controller;

import com.example.Project06.Dto.*;
import com.example.Project06.Service.UserService;
import com.example.Project06.exception.InvalidPasswordException;
import com.example.Project06.exception.PageNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import com.example.Project06.utils.BaseResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/index")
    public ResponseEntity<String> index(Principal principal){
        return ResponseEntity.ok("Welcome to user page : " + principal.getName());
    }

    @PatchMapping("/updateUserDetails")
    public ResponseEntity<?> updateDetails(@RequestBody RegisterDto userDTO) {
        try {
            userService.updateDetails(userDTO);

            UserupdateDTO userupdateDTO = new UserupdateDTO("success");
            userupdateDTO.setMessage("User Details Updated");

            return ResponseEntity.status(HttpStatus.OK).body(userupdateDTO);
        } catch (UserNotFoundExceptions e) {
            UserupdateDTO userupdateDTO = new UserupdateDTO("Unsuccess");
            userupdateDTO.setException(String.valueOf(e));

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userupdateDTO);

        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getUserById(@RequestParam Integer userId) {
        try {
            RUserSingleDto responseDto = new RUserSingleDto("Success");
            responseDto.setResponse(userService.getUserById(userId));
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (UserNotFoundExceptions e) {
            UserupdateDTO userupdateDTO = new UserupdateDTO("Unsuccess");
            userupdateDTO.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userupdateDTO);

        }
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<ResponseAllUsersDto> getAllUser(@RequestParam int pageNo) {

        try {
            List<GetAllUserDTO> list = userService.getAllUsers(pageNo);
            ResponseAllUsersDto responseAllUsersDto = new ResponseAllUsersDto("success");
            responseAllUsersDto.setList(list);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllUsersDto);
        } catch (UserNotFoundExceptions e) {
            ResponseAllUsersDto responseAllCarDto = new ResponseAllUsersDto("unsuccess");
            responseAllCarDto.setException("car not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllCarDto);
        } catch (PageNotFoundException exception) {
            ResponseAllUsersDto responseAllCarDto = new ResponseAllUsersDto("unsuccess");
            responseAllCarDto.setException("page not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllCarDto);
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

    @PostMapping("/forgot-password")
    public ResponseEntity<ResponseDto> forgotPass(HttpServletRequest request) throws UserNotFoundExceptions {
        try {

            String email = request.getParameter("email");

            String token = RandomStringUtils.randomAlphabetic(40);

            LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(1);

            userService.updateResetPassword(token, email);

            String resetPasswordLink = "http://localhost:8080/new/reset-password?token=" + token;

            ResponseDto response = userService.forgotPass(email, resetPasswordLink, request.getServerName());

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("Successful", response.getMessage()));
        } catch (UserNotFoundExceptions e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Unsuccessful", "Invalid email. Please register."));
        }
    }

    @GetMapping("/reset-password")
    public String resetPasswordPage(@RequestParam(name = "token") String token, Model model) {
        model.addAttribute("token", token);
        return "passrest";
    }


    @PostMapping("/update-password")
    public ResponseEntity<ResponseDto> resetPassword(@RequestBody ResetPassword resetPassword) throws UserNotFoundExceptions {

        try {
            String token = resetPassword.getToken();
            String newPassword = resetPassword.getPassword();

            ResponseDto response = userService.updatePassword(token, newPassword);

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("Successful", response.getMessage()));

        } catch (UserNotFoundExceptions e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Unsuccessful", "Something went wrong"));
        }
    }



}
