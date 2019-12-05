package softuni.winelovers.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import softuni.winelovers.service.models.user.UserLoginServiceModel;
import softuni.winelovers.service.models.user.UserRegisterServiceModel;
import softuni.winelovers.service.services.UserService;
import softuni.winelovers.web.models.users.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "users/login.html";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute LoginUserModel model, HttpSession session) {
        try {
            UserLoginServiceModel user = this.userService.login(model);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole().toString());
            return "redirect:/home/welcome";
        } catch (Exception e) {
            return "redirect:/users/login";
        }

    }

    @GetMapping("/register")
    public String getRegister() {
        return "users/register.html";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegisterUserModel model) throws MessagingException {
        userService.register(modelMapper.map(model, UserRegisterServiceModel.class));
        return "redirect:/users/confirm-email";
    }

    @GetMapping("/confirm-email")
    public String getConfirmEmail(@RequestParam(required = false) String id) {
        return "users/confirm-email";
    }

    @PostMapping("/confirm-email")
    public String confirmEmail(@ModelAttribute ConfirmationCodeModel model) {
        this.userService.confirmEmail(model.getCode());
        return "redirect:/users/login";
    }

    @GetMapping("/logout")
    public String getLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String getProfile(HttpSession session){
        String username = ((UserLoginServiceModel)session.getAttribute("user")).getUsername();
        UserProfileModel userProfile = this.modelMapper.map(this.userService.getProfile(username), UserProfileModel.class);
        session.setAttribute("userProfile", userProfile);
        return "users/profile";
    }

    @GetMapping("/change-password")
    public String getChangePassword(HttpSession session){
        return "/users/change-password";
    }

    @PostMapping("/change-password")
    public String changePassword(@ModelAttribute ChangePasswordModel model, HttpSession session) throws Exception {
        String username = ((UserLoginServiceModel)session.getAttribute("user")).getUsername();
        this.userService.changePassword(username, model.getOldPassword(), model.getNewPassword(), model.getConfirmNewPassword());
        System.out.println();
        return "redirect:/users/profile";
    }
}
