package com.softuni.battleShips.controllers;

import com.softuni.battleShips.models.dto.ShipDTO;
import com.softuni.battleShips.services.ShipService;
import com.softuni.battleShips.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final LoggedUser loggedUser;

    @Autowired
    public HomeController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public String loggedOutIndex(){
        return "index";
    }
    @GetMapping("/home")
    public String loggedInIndex(Model model){
        long loggedUserId = this.loggedUser.getId();
        List<ShipDTO> ownShips = this.shipService.getShipsOwnedBy(loggedUserId);
        List<ShipDTO> enemyShips = this.shipService.getShipsNotOwnedBy(loggedUserId);
        List<ShipDTO> sortedShips = this.shipService.getAllSorted();

        model.addAttribute("ownShips", ownShips);
        model.addAttribute("enemyShips", enemyShips);

        return "home";
    }
}
