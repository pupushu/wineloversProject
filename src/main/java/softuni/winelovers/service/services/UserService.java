package softuni.winelovers.service.services;

import softuni.winelovers.service.models.user.UserLoginModelService;
import softuni.winelovers.service.models.user.UserProfileModelService;
import softuni.winelovers.service.models.user.UserRegisterModelService;
import softuni.winelovers.web.models.users.LoginUserModel;

import javax.mail.MessagingException;

public interface UserService {
    void register(UserRegisterModelService model) throws MessagingException;

    void confirmEmail(String str);

    UserLoginModelService login(LoginUserModel model) throws Exception;

    UserProfileModelService getProfile(String username);

    void changePassword(String username, String oldPassword, String newPassword, String confirmNewPassword) throws Exception;

    void addWineToUser(String wineId, String username);

}
