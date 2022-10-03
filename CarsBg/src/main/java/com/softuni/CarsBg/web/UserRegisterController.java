package com.softuni.CarsBg.web;

import com.softuni.CarsBg.model.dto.UserRegisterDTO;
import com.softuni.CarsBg.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegisterController {
    private UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserRegisterDTO initUserModel() {
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);

            return "redirect:/users/register";
        }
        userService.registerAndLogin(userRegisterDTO);
        return "redirect:/";
    }
}
