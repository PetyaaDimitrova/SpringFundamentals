package com.softuni.shoppingList.controllers;

import com.softuni.shoppingList.models.dtos.UserLoginDTO;
import com.softuni.shoppingList.models.dtos.UserRegistrationDTO;
import com.softuni.shoppingList.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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

        if(bindingResult.hasErrors() || !this.userService.register(registrationDTO)){
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.registrationDTO", bindingResult);
            return "redirect:/register";
        }
        return "redirect:/login";

    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);
            return "redirect:/login";
        }
        if(!this.userService.login(loginDTO)){
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:/login";
        }
        return "redirect:/home";

    }
    @GetMapping("/logout")
    public String logout() {
        this.userService.logout();

        return "redirect:/";
    }
}
