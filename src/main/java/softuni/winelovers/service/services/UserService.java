package softuni.winelovers.service.services;

import softuni.winelovers.service.models.user.UserLoginServiceModel;
import softuni.winelovers.service.models.user.UserProfileServiceModel;
import softuni.winelovers.service.models.user.UserRegisterServiceModel;
import softuni.winelovers.web.models.users.LoginUserModel;

import javax.mail.MessagingException;

public interface UserService {
    void register(UserRegisterServiceModel model) throws MessagingException;

    void confirmEmail(String str);

    UserLoginServiceModel login(LoginUserModel model) throws Exception;

    UserProfileServiceModel getProfile(String username);

    void changePassword(String username, String oldPassword, String newPassword, String confirmNewPassword) throws Exception;
}
