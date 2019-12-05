package softuni.winelovers.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/welcome")
    public String getWelcome(HttpSession session){
        return "home/welcome.html";
    }

    @GetMapping("/index")
    public String getIndex(){
        return "home/index.html";
    }

}
