package com.example.Project06.Service;



import com.example.Project06.Dto.PasswordChange;
import com.example.Project06.Dto.RegisterDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.exception.UserNotFoundExceptions;
import com.example.Project06.utils.BaseResponseDTO;

import java.util.List;

public interface UserService {
    BaseResponseDTO registerAccount(RegisterDto registerDto);

    /**
     This method is used to change the password for a user.
     @param id The ID of the user for whom the password needs to be changed.
     @param passwordChange An object containing the old password, new password, and confirm password.
     @return BaseResponseDTO An object representing the response of the password change operation.
     */
    BaseResponseDTO changePassword(int id, PasswordChange passwordChange);

    BaseResponseDTO editUser(RegisterDto userProfileDto, int id);



    /**
     Updates the reset password token for a user with the specified email.
     @param token The reset password token to be set for the user.
     @param email The email of the user whose reset password token is being updated.
     @throws UserNotFoundExceptions If no user is found with the given email.
     */
    void updateResetPassword(String token, String email);

    /**
     Sends a password reset email to the specified email address.
     If the email belongs to a registered user, an email is sent with a password reset link.
     If the email does not belong to any registered user, a UserNotFoundException is thrown.
     @param email The email address of the user requesting a password reset.
     @param resetPasswordLink The password reset link to be included in the email.
     @param domain The domain of the application.
     @return A ResponseDto indicating the status of the operation.
     @throws UserNotFoundExceptions If the email does not belong to any registered user.
     */
    ResponseDto forgotPass(String email, String resetPasswordLink, String domain) throws UserNotFoundExceptions;

    /**
     * Updates the password for a user based on a reset password token.
     *
     * @param token         The reset password token used to identify the user.
     * @param newPassword  The new password to be set for the user.
     * @return              A ResponseDto object indicating the status and message of the operation.
     */
    ResponseDto updatePassword(String token, String newPassword);
}
