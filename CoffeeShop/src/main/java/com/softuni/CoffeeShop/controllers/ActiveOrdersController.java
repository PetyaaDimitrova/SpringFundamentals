package com.softuni.CoffeeShop.controllers;

import com.softuni.CoffeeShop.models.dto.OrderDTO;
import com.softuni.CoffeeShop.services.ActiveOrdersService;
import com.softuni.CoffeeShop.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ActiveOrdersController {

    private final ActiveOrdersService activeOrdersService;
    private final AuthService authService;

    public ActiveOrdersController(ActiveOrdersService activeOrdersService, AuthService authService) {
        this.activeOrdersService = activeOrdersService;
        this.authService = authService;
    }


    @PostMapping("/allActiveOrders")
    public String order(@Valid OrderDTO orderDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (!this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderDTO", orderDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.orderDTO", bindingResult);

            return "redirect:/home";
        }

        this.activeOrdersService.prepare(orderDTO);

        return "redirect:/home";
    }
}
