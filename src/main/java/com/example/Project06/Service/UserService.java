package com.example.Project06.Service;

import com.example.Project06.Dto.GetAllUserDTO;
import com.example.Project06.Dto.PasswordChange;
import com.example.Project06.Dto.RegisterDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.exception.UserNotFoundExceptions;
import com.example.Project06.utils.BaseResponseDTO;

import java.util.List;

public interface UserService {
    BaseResponseDTO registerAccount(RegisterDto registerDto);

    BaseResponseDTO changePassword(int id, PasswordChange passwordChange);


    void updateResetPassword(String token, String email);

    public void updateDetails (RegisterDto userDTO);

    public RegisterDto getUserById(Integer userId);

    List<GetAllUserDTO> getAllUsers(int pageNo);


    ResponseDto forgotPass(String email, String resetPasswordLink, String domain) throws UserNotFoundExceptions;

    ResponseDto updatePassword(String token, String newPassword);
}
