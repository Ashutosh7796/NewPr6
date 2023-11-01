package com.example.Project06.ServiceImpl;


import com.example.Project06.Dto.PasswordChange;
import com.example.Project06.Dto.RegisterDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Entity.Role;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.RoleRepository;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.UserService;
import com.example.Project06.exception.*;
import com.example.Project06.utils.BaseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired

    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public BaseResponseDTO registerAccount(RegisterDto registerDto) {
        BaseResponseDTO response = new BaseResponseDTO();

        validateAccount(registerDto);

        User user = insertUser(registerDto);


        try {
            userRepository.save(user);
            response.setCode(String.valueOf(HttpStatus.OK.value()));
            response.setMessage("Account Created");
        } catch (UserAlreadyExistException e) {
            response.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
            response.setMessage("User already exist");
        }catch (BaseException e){
            response.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
            response.setMessage("Invalid role");
        }
        return response;
    }

    private User insertUser(RegisterDto registerDto) {
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setMoNumber(registerDto.getMoNumber());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setGender(registerDto.getGender());
        user.setRef(registerDto.getRef());
        user.setDate(registerDto.getDate());
        user.setFullName(registerDto.getFullName());
        user.setStatus(registerDto.getStatus());

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(registerDto.getRoles());
        roles.add(role);
        user.setRoles(roles);

        if (role.getName().equals("USER")) {
            User profile = new User();
            profile.setFullName(registerDto.getFullName());
            profile.setMoNumber(registerDto.getMoNumber());
            profile.setEmail(registerDto.getEmail());
            profile.setPassword(registerDto.getPassword());
            profile.setGender(registerDto.getGender());
            profile.setRef(registerDto.getRef());
            profile.setStatus(registerDto.getStatus());
            profile.setDate(registerDto.getDate());
            userRepository.save(user);
        }

        return user;
    }

    private void validateAccount(RegisterDto registerDto) {
        // validate null data
        if (ObjectUtils.isEmpty(registerDto)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Data must not be empty");
        }

        // validate duplicate username
        User user = userRepository.findByEmail(registerDto.getEmail());
        if (!ObjectUtils.isEmpty(user)) {
            throw new UserAlreadyExistException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Username already exists");
        }

        // validate role
        List<String> roles = roleRepository.findAll().stream().map(Role::getName).toList();
        if (!roles.contains(registerDto.getRoles())) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Invalid role");
        }
    }

    @Override
    public BaseResponseDTO changePassword(int id, PasswordChange passwordChange) {
        // Create a new BaseResponseDTO object to store the response
        BaseResponseDTO response = new BaseResponseDTO();

        // Retrieve the user with the given id from the userRepository
        Optional<User> userOptional = userRepository.findById(id);

        // Check if the user exists
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Check if the old password matches the stored password for the user
            if (passwordEncoder.matches(passwordChange.getOldPassword(), user.getPassword())) {

                // Check if the new password and confirm password match
                if (passwordChange.getNewPassword().equals(passwordChange.getConfirmPassword())) {
                    // Encode and set the new password for the user
                    user.setPassword(passwordEncoder.encode(passwordChange.getNewPassword()));
                    userRepository.save(user);

                    // Set the response code and message for a successful password change
                    response.setCode(String.valueOf(HttpStatus.OK.value()));
                    response.setMessage("Password changed");
                } else {
                    // Set the response code and throw an exception for password mismatch
                    response.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
                    throw new InvalidPasswordException("New password and confirm password does not match");
                }
            } else {
                // Set the response code and throw an exception for invalid password
                response.setCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
                throw new InvalidPasswordException("Invalid Password");
            }

        } else {
            // Throw an exception if no user is found with the given id
            throw new UserNotFoundExceptions("No user found");
        }

        // Return the response object
        return response;
    }


    private RegisterDto convertToDto(User user ) {
        //User user = new User();
        RegisterDto userProfileDto = new RegisterDto();
        userProfileDto.setFullName(user.getFullName());
        userProfileDto.setMoNumber(user.getMoNumber());
        userProfileDto.setEmail(user.getEmail());
        userProfileDto.setPassword(user.getPassword());
        userProfileDto.setGender(user.getGender());
        userProfileDto.setRef(user.getRef());
        userProfileDto.setStatus(user.getStatus());
        userProfileDto.setDate(user.getDate());
        return userProfileDto;
    }




    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public ResponseDto forgotPass(String email, String resetPasswordLink, String domain) throws UserNotFoundExceptions {
        ResponseDto response = new ResponseDto();

        // Find the user with the specified email
        User user = userRepository.findByEmail(email);

        if (user != null) {
            // Set the email message content
            String message = "Hello this is Aniket";

            // Set the password reset link
            String resetLink = resetPasswordLink;

            // Set the email subject
            String subject = "Checking: confirmation";

            // Set the sender's email address
            String from = "b.aniket1414@gmail.com";

            // Set the recipient's email address
            String to = email;

            // Send the email using the sendEmail() method
            sendEmail(message, subject, to, from, resetLink, domain);

            // Update the response with success status and message
            response.setStatus(String.valueOf(HttpStatus.OK.value()));
            response.setMessage("Email sent");

        } else {
            // The user with the specified email was not found
            response.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
            response.setMessage("User not found");
            throw new UserNotFoundExceptions("User not found");
        }

        // Return the response
        return response;
    }

    // @Override
    public void sendEmail(String message, String subject, String to, String from, String resetLink, String domain) {


        // SMTP server for Gmail
        String host = "smtp.gmail.com";

        // Getting the system properties
        Properties properties = System.getProperties();

        System.out.println(properties);

        // Setting important information to the properties object
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Creating a session with the properties and an authenticator
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // Return the email address and password for authentication
                return new PasswordAuthentication("b.aniket1414@gmail.com", "egmqlowlfodymfzw");
            }

        });

        // Composing the email content
        String content = "To reset your password, click here: " + resetLink.replace("169.254.63.118:5173", domain);

        // Creating a MimeMessage object for the session
        MimeMessage m = new MimeMessage(session);

        try {
            // Setting the sender of the email
            m.setFrom(from);

            // Adding the recipient to the message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Adding the subject to the message
            m.setSubject(subject);

            // Adding the content to the message
            m.setText(content);

            // Sending the message
            Transport.send(m);

        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }

    public void updateResetPassword(String token, String email) throws UserNotFoundExceptions {
        // Find the user with the specified email in the user repository
        User user = userRepository.findByEmail(email);

        // Check if a user was found with the given email
        if (user != null) {
            // Set the reset password token for the user
            user.setResetPasswordToken(token);
            // Save the updated user in the user repository
            userRepository.save(user);
        } else {
            // Throw a UserNotFoundExceptions indicating that no user was found with the given email
            throw new UserNotFoundExceptions("could not find any user with this email");
        }
    }

    public ResponseDto updatePassword(String token, String newPassword) {
        // Create a new ResponseDto object to hold the response details
        ResponseDto response = new ResponseDto();

        // Find the user based on the reset password token
        User user = userRepository.findByResetPasswordToken(token);

        if (user != null) {
            // Create an instance of BCryptPasswordEncoder to encode the new password
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            // Encode the new password using BCryptPasswordEncoder
            String encodedPassword = bCryptPasswordEncoder.encode(newPassword);

            // Update the user's password with the encoded password
            user.setPassword(encodedPassword);

            // Clear the reset password token as it is no longer needed
            user.setResetPasswordToken(null);

            // Save the updated user object in the repository
            userRepository.save(user);

            // Set the status and message in the response indicating a successful password update
            response.setStatus(String.valueOf(HttpStatus.OK.value()));
            response.setMessage("Successful");
        } else {
            // If the user is not found based on the reset password token, handle the error
            response.setStatus(String.valueOf(HttpStatus.OK.value()));
            response.setMessage("Email sent");

            // Throw a UserNotFoundExceptions indicating that something went wrong
            throw new UserNotFoundExceptions("Something went wrong");
        }

        // Return the response object
        return response;
    }

    @Override
    public BaseResponseDTO editUser(RegisterDto userProfileDto, int id) {

        // create a new response object
        BaseResponseDTO response = new BaseResponseDTO();

        // find the user with the given id in the repository
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            // if the user is found, update the user's details with the values from the DTO object
            user.get().setFullName(userProfileDto.getFullName());
            user.get().setDate(userProfileDto.getDate());
            user.get().setStatus(userProfileDto.getStatus());
            user.get().setMoNumber(userProfileDto.getMoNumber());
            user.get().setEmail(userProfileDto.getEmail());
            user.get().setGender(userProfileDto.getGender());

            // save the updated user in the repository
            userRepository.save(user.get());

            // set the response code and message indicating the success of the operation
            response.setCode(String.valueOf(HttpStatus.OK.value()));
            response.setMessage("User edited");
        } else {
            // if the user is not found, set the response code and throw a UserNotFoundException
            response.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
            throw new UserNotFoundExceptions("No user found");
        }

        // return the response object
        return response;
    }

}
