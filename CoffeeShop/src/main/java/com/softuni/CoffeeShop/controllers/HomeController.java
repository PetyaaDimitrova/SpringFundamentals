package com.softuni.CoffeeShop.controllers;

import com.softuni.CoffeeShop.services.AuthService;
import com.softuni.CoffeeShop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    private final OrderService orderService;

    private final AuthService authService;

  //  @ModelAttribute("startBattleDTO")
  //  public StartBattleDTO initBattleForm() {
   //     return new StartBattleDTO();
 //   }

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

        long loggedUserId = this.authService.getLoggedUserId();

    //    List<ShipDTO> ownShips = this.shipService.getShipsOwnedBy(loggedUserId);
    //    List<ShipDTO> enemyShips = this.shipService.getShipsNotOwnedBy(loggedUserId);
     //   List<ShipDTO> sortedShips = this.shipService.getAllSorted();

      //  model.addAttribute("ownShips", ownShips);
     //   model.addAttribute("enemyShips", enemyShips);
     //   model.addAttribute("sortedShips", sortedShips);

        return "home";
    }
}
