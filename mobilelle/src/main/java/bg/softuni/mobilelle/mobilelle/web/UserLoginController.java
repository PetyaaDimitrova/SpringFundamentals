package bg.softuni.mobilelle.mobilelle.web;

import bg.softuni.mobilelle.mobilelle.dto.UserLoginDTO;
import bg.softuni.mobilelle.mobilelle.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping ("/users/login")
    public String login(UserLoginDTO userLoginDTO){

        System.out.println("User is logged: " + userService.login(userLoginDTO));
        return "redirect:/";
    }
}
