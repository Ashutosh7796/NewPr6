package com.example.Project06.Controller;

import com.example.Project06.Dto.*;
import com.example.Project06.Service.UserService;
import com.example.Project06.exception.InvalidPasswordException;
import com.example.Project06.exception.PageNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import com.example.Project06.utils.BaseResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.time.LocalDateTime;
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
            responseDto.getResponse().setPassword("");
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
            // Retrieve the email from the request
            String email = request.getParameter("email");

            // Generate a random token for password reset
            String token = RandomStringUtils.randomAlphabetic(40);

            // Calculate the expiration time (24 hours from now)
            LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(1);

            // Update the user's reset password token in the userService
            userService.updateResetPassword(token, email);

            // Construct the reset password link using the request's server name and token
            String resetPasswordLink = "http://localhost:8080/reset-password?token=" + token;

            // Call the userService's forgotPass() method to send the password reset email
            ResponseDto response = userService.forgotPass(email, resetPasswordLink, request.getServerName());

            // Return a ResponseEntity object with the appropriate status and message
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("Successful", response.getMessage()));
        } catch (UserNotFoundExceptions e) {

            // Handle the case where the email does not belong to a registered user
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Unsuccessful", "Invalid email. Please register."));
        }
    }

    @GetMapping("/reset-password")
    public String resetPasswordPage(@RequestParam(name = "token") String token, Model model) {
        model.addAttribute("token", token);
        return "resetPassword";
    }
    @PostMapping("/update-password")
    public ResponseEntity<ResponseDto> resetPassword(@RequestBody ResetPassword resetPassword) throws UserNotFoundExceptions {

        try {
            String token = resetPassword.getToken();
            String newPassword = resetPassword.getPassword();

            // Invoke the userService.updatePassword() method to update the user's password
            ResponseDto response = userService.updatePassword(token, newPassword);

            // Return a ResponseEntity with success status (200) and a ResponseDto with success message
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("Successful", response.getMessage()));

        } catch (UserNotFoundExceptions e) {
            // If a UserNotFoundException is caught, return a ResponseEntity with not found status (404)
            // and a ResponseDto with an error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Unsuccessful", "Something went wrong"));
        }
    }



}
