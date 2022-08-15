package com.softuni.CoffeeShop.controllers;

import com.softuni.CoffeeShop.models.Category;
import com.softuni.CoffeeShop.models.OrderType;
import com.softuni.CoffeeShop.models.dto.OrderDTO;
import com.softuni.CoffeeShop.services.AuthService;
import com.softuni.CoffeeShop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final OrderService orderService;

    private final AuthService authService;

    @ModelAttribute("orderDTO")
    public OrderDTO initBattleForm() {
        return new OrderDTO();
    }

    @Autowired
    public HomeController(OrderService orderService, AuthService authService) {
        this.orderService = orderService;
        this.authService = authService;
    }

    @GetMapping("/")
    public String loggedOutIndex() {
        if (this.authService.isLoggedIn()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String loggedInIndex(Model model) {
        if (!this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        List<OrderDTO> orders = this.orderService.findAllOrderOrderByPriceDesc();


        model.addAttribute("orders", orders);
        model.addAttribute("totalTime", orders.stream()
                .map(orderDTO -> orderDTO.getCategory().getNeededTime())
                .reduce(Integer::sum).orElse(null));

       // model.addAttribute("sorted", authService.findAllUserAndCountOfOrdersOrderByCountDesc());

        return "home";
    }
}
