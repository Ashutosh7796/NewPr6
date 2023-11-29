package com.example.Project06.ServiceImpl;


import com.example.Project06.Dto.*;
import com.example.Project06.Entity.*;
import com.example.Project06.Repository.*;
import com.example.Project06.Service.UserService;
import com.example.Project06.exception.*;
import com.example.Project06.utils.BaseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final EmailVerificationRepo emailVerificationRepo;

    private final CompanyRepository companyRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final HrRepository hrRepository;

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
//        EmailVerification emailVerification = emailVerificationRepo.findByEmail(registerDto.getEmail());
        User user = new User();
//        if (emailVerification != null && !Objects.equals(emailVerification.getStatus(), "Not verified"));
//            else {
//            throw new EmailNotVerifiedException("Email not verified");
//        }
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

        if (role.getName().equals("STUDENT")) {
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
        } else if (role.getName().equals("COMPANY")) {

            if (isDuplicateGSTNumber(registerDto.getGestnNo())) {
                throw new DuplicateGSTNumberException("Duplicate GST number");
            }
            Company company = new Company();
            company.setCompanyName(registerDto.getCompanyName());
            company.setGestnNo(registerDto.getGestnNo());
            company.setCompanyServices(registerDto.getCompanyServices());
            company.setCompanyType(registerDto.getCompanyType());
            company.setCompanyLevel(registerDto.getCompanyLevel());
            company.setLogo(registerDto.getLogo());
            company.setOfficeAddress(registerDto.getOfficeAddress());
            company.setCompanyLocations(registerDto.getCompanyLocations());
            company.setOneCopmpanyDoc(registerDto.getOneCompanyDoc());

            if (registerDto.getRefNo() == null || registerDto.getRefNo().isEmpty()) {
                String randomRefNo = RandomStringUtils.randomAlphanumeric(8);
                company.setRefNo(randomRefNo);
            } else {
                company.setRefNo(registerDto.getRefNo());
            }
            company.setCompanyStatus(registerDto.getStatus());
            company.setUserUser(user);
            companyRepository.save(company);

        } else if (role.getName().equals("HR") ) {
            String refNoOfCompany = registerDto.getRefNoOfCompany();

            if (refNoOfCompany == null || refNoOfCompany.trim().isEmpty()) {
                throw new InvalidHRRegistrationException("HR registration requires a valid refNoOfCompany");
            }

            Company company = companyRepository.findByRefNo(refNoOfCompany);
            Hr hr = new Hr();
            hr.setDesignation(registerDto.getDesignation());
            hr.setHrstatus(registerDto.getHrstatus());
            hr.setRefNoOfCompany(registerDto.getRefNoOfCompany());
            hr.setUserUser(user);
            hr.setCompanyCompany(company);
            hrRepository.save(hr);
        }

        return user;
    }

    private boolean isDuplicateGSTNumber(String gstNumber) {
        Company existingCompany = companyRepository.findByGestnNo(gstNumber);
        return existingCompany != null;
    }

    private void validateAccount(RegisterDto registerDto) {
        // validate null data
        if (ObjectUtils.isEmpty(registerDto)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Data must not be empty");
        }

        // validate duplicate username
        User user = userRepository.findByEmail(registerDto.getEmail());
        if (!ObjectUtils.isEmpty(user)) {
            throw new UserAlreadyExistException(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        }

        // validate role
        List<String> roles = roleRepository.findAll().stream().map(Role::getName).toList();
        if (!roles.contains(registerDto.getRoles())) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Invalid role");
        }
    }

    @Override
    public BaseResponseDTO changePassword(int id, PasswordChange passwordChange) {

        BaseResponseDTO response = new BaseResponseDTO();

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (passwordEncoder.matches(passwordChange.getOldPassword(), user.getPassword())) {

                if (passwordChange.getNewPassword().equals(passwordChange.getConfirmPassword())) {

                    user.setPassword(passwordEncoder.encode(passwordChange.getNewPassword()));
                    userRepository.save(user);

                    response.setCode(String.valueOf(HttpStatus.OK.value()));
                    response.setMessage("Password changed");
                } else {

                    response.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
                    throw new InvalidPasswordException("New password and confirm password does not match");
                }
            } else {

                response.setCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
                throw new InvalidPasswordException("Invalid Password");
            }

        } else {

            throw new UserNotFoundExceptions("No user found");
        }

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

        User user = userRepository.findByEmail(email);

        if (user != null) {

            String message = "Dear User this is the link to reset your password";

            String resetLink = resetPasswordLink;

            String subject = "Reset Password";

            String from = "b.aniket1414@gmail.com";

            String to = email;

            sendEmail(message, subject, to, from, resetLink, domain);

            response.setStatus(String.valueOf(HttpStatus.OK.value()));
            response.setMessage("Email sent");

        } else {
            response.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
            response.setMessage("User not found");
            throw new UserNotFoundExceptions("User not found");
        }

        return response;
    }

    public void sendEmail(String message, String subject, String to, String from, String resetLink, String domain) {


        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        System.out.println(properties);

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("b.aniket1414@gmail.com", "egmqlowlfodymfzw");
            }

        });

        String content = "To reset your password, click here: " + resetLink.replace("169.254.63.118:5173", domain);

        MimeMessage m = new MimeMessage(session);

        try {
            m.setFrom(from);

            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            m.setSubject(subject);

            m.setText(content);

            Transport.send(m);

        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }

    public void updateResetPassword(String token, String email) throws UserNotFoundExceptions {

        User user = userRepository.findByEmail(email);

        if (user != null) {

            user.setResetPasswordToken(token);

            userRepository.save(user);
        } else {

            throw new UserNotFoundExceptions("could not find any user with this email");
        }
    }

    public ResponseDto updatePassword(String token, String newPassword) {

        ResponseDto response = new ResponseDto();

        User user = userRepository.findByResetPasswordToken(token);

        if (user != null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            String encodedPassword = bCryptPasswordEncoder.encode(newPassword);

            user.setPassword(encodedPassword);

            user.setResetPasswordToken(null);

            userRepository.save(user);

            response.setStatus(String.valueOf(HttpStatus.OK.value()));
            response.setMessage("Successful");
        } else {
            response.setStatus(String.valueOf(HttpStatus.OK.value()));
            response.setMessage("Email sent");

            throw new UserNotFoundExceptions("Something went wrong");
        }

        return response;
    }
    @Override
    public void updateDetails(RegisterDto userDTO) {
        User user = userRepository.findById(userDTO.getId()).orElseThrow(()-> new UserNotFoundExceptions("User Not Found", HttpStatus.NOT_FOUND));
        if (userDTO.getEmail() != null){
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getFullName() != null) {
            user.setFullName(userDTO.getFullName());
        }
        if (userDTO.getMoNumber() != null) {
            user.setMoNumber(userDTO.getMoNumber());
        }
        if (userDTO.getStatus() != null) {
            user.setStatus(userDTO.getStatus());
        }
        if (userDTO.getRef() != null) {
            user.setRef(userDTO.getRef());
        }

        userRepository.save(user);

    }

    @Override
    public GetSingleUserDto getUserById(Integer userId) {
        Optional<User> user =userRepository.findById(userId);

        if(user.isEmpty())
        {
            throw new UserNotFoundExceptions("user not found by id ");
        }
        GetSingleUserDto userDTO = new GetSingleUserDto(user.get());
        return userDTO;
    }

    @Override
    public List<GetAllUserDTO> getAllUsers(int pageNo) {
        List<User> listOfUsers = userRepository.findAll();

        if((pageNo*10)>listOfUsers.size()-1){
            throw new PageNotFoundException("page not found");

        }
        if(listOfUsers.size()<=0){throw new UserNotFoundExceptions("user not found",HttpStatus.NOT_FOUND);}

        List<GetAllUserDTO> listOfUsersDto = new ArrayList<>();

        int pageStart=pageNo*10;
        int pageEnd=pageStart+10;
        int diff=(listOfUsers.size()) - pageStart;
        for(int counter=pageStart,i=1;counter<pageEnd;counter++,i++){
            if(pageStart>listOfUsers.size()){break;}


            GetAllUserDTO userDto = new GetAllUserDTO (listOfUsers.get(counter));
            userDto.setId(listOfUsers.get(counter).getUser_id());
            listOfUsersDto.add(userDto);


            if(diff == i){
                break;
            }
        }

        return listOfUsersDto;
    }

}
