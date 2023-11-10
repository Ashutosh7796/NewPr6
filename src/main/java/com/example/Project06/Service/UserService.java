package com.example.Project06.Service;

import com.example.Project06.Dto.*;
import com.example.Project06.exception.UserNotFoundExceptions;
import com.example.Project06.utils.BaseResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    BaseResponseDTO registerAccount(RegisterDto registerDto);

    BaseResponseDTO changePassword(int id, PasswordChange passwordChange);


    void updateResetPassword(String token, String email);

    public void updateDetails (RegisterDto userDTO);

    public GetSingleUserDto getUserById(Integer userId);

    List<GetAllUserDTO> getAllUsers(int pageNo);

    ResponseDto forgotPass(String email, String resetPasswordLink, String domain) throws UserNotFoundExceptions;

    ResponseDto updatePassword(String token, String newPassword);
}
