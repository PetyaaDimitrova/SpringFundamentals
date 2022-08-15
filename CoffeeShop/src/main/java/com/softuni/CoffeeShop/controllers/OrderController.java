package com.softuni.CoffeeShop.controllers;

import com.softuni.CoffeeShop.models.dto.CreateOrderDTO;
import com.softuni.CoffeeShop.models.dto.OrderDTO;
import com.softuni.CoffeeShop.services.AuthService;
import com.softuni.CoffeeShop.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OrderController {

    private final OrderService orderService;

    private final AuthService authService;

    public OrderController(OrderService orderService, AuthService authService) {
        this.orderService = orderService;
        this.authService = authService;
    }

    @ModelAttribute("createOrderDTO")
    public CreateOrderDTO initCreateOrderDTO() {
        return new CreateOrderDTO();
    }

    @ModelAttribute("orderDTO")
    public OrderDTO initOrderForm() {
        return new OrderDTO();
    }

    @GetMapping("/orders/add")
    public String orders() {
        if (!this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        return "order-add";
    }

    @PostMapping("/orders/add")
    public String order(@Valid CreateOrderDTO createOrderDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (!this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !this.orderService.create(createOrderDTO)) {
            redirectAttributes.addFlashAttribute("createOrderDTO", createOrderDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createOrderDTO", bindingResult);

            return "redirect:/orders/add";
        }

        return "redirect:/home";
    }

    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id) {
       orderService.readyOrder(id);

        return "redirect:/home";
    }
}
