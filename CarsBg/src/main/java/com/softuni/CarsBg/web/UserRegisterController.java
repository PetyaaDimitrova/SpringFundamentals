package com.softuni.CarsBg.web;

import com.softuni.CarsBg.model.dto.UserLoginDTO;
import com.softuni.CarsBg.model.dto.UserRegisterDTO;
import com.softuni.CarsBg.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserRegisterController {
    private UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO) {
        userService.registerAndLogin(userRegisterDTO);
        return "redirect:/";
    }
}
