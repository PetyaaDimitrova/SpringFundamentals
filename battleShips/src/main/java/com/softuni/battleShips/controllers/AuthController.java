package com.softuni.battleShips.controllers;

import com.softuni.battleShips.models.dto.UserLoginDTO;
import com.softuni.battleShips.models.dto.UserRegistrationDTO;
import com.softuni.battleShips.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("registrationDTO")
    public UserRegistrationDTO initRegistrationDTO(){
        return new UserRegistrationDTO();
    }
    @ModelAttribute("loginDTO")
    public UserLoginDTO initLoginDTO(){
        return new UserLoginDTO();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO registrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() || !this.authService.register(registrationDTO)){
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.registrationDTO", bindingResult);
            return "redirect:/register";
        }
        return "redirect:/login"; //////

    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() || !this.authService.login(loginDTO)){
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);
            return "redirect:/login";
        }
        return "redirect:/home"; //////

    }
}
