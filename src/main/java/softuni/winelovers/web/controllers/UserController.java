package softuni.winelovers.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softuni.winelovers.service.models.user.UserLoginModelService;
import softuni.winelovers.service.models.user.UserRegisterModelService;
import softuni.winelovers.service.services.UserService;
import softuni.winelovers.web.models.users.*;
import softuni.winelovers.web.models.wines.GetWineModel;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.List;

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
            UserLoginModelService user = this.userService.login(model);
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
        userService.register(modelMapper.map(model, UserRegisterModelService.class));
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
        String username = ((UserLoginModelService)session.getAttribute("user")).getUsername();
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
        String username = ((UserLoginModelService)session.getAttribute("user")).getUsername();
        this.userService.changePassword(username, model.getOldPassword(), model.getNewPassword(), model.getConfirmNewPassword());
        System.out.println();
        return "redirect:/users/profile";
    }

    @PostMapping("add-wine/{id}")
    public String addWineToUser(@PathVariable String id,
                              HttpSession session){
        UserLoginModelService user = (UserLoginModelService) session.getAttribute("user");
        this.userService.addWineToUser(id, user.getUsername());
        return "wines/all-wines.html";
    }

    @GetMapping("my-wines")
    public ModelAndView getMyWines(ModelAndView modelAndView,
                                   HttpSession session){
        UserLoginModelService userLoginServiceModel = (UserLoginModelService) session.getAttribute("user");
        UserProfileModel user = this.modelMapper.map(this.userService.getProfile(userLoginServiceModel.getUsername()), UserProfileModel.class);
        List<GetWineModel> wines = user.getWines();
        modelAndView.addObject("wines", wines);
        modelAndView.setViewName("/users/my-wines");
        return modelAndView;
    }
}
