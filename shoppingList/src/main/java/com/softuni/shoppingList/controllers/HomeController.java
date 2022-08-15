package com.softuni.shoppingList.controllers;

import com.softuni.shoppingList.models.dtos.AddSongDTO;
import com.softuni.shoppingList.models.dtos.SongDTO;
import com.softuni.shoppingList.services.SongService;
import com.softuni.shoppingList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final SongService songService;

    private final UserService userService;

    /*
    @ModelAttribute("startBattleDTO")
    public StartBattleDTO initBattleForm() {
        return new StartBattleDTO();
    }

     */
    @Autowired
    public HomeController(SongService songService, UserService userService) {
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String loggedOutIndex() {
        if (this.userService.isLoggedIn()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String loggedInIndex(Model model) {
        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }

        long loggedUserId = this.userService.getLoggedUserId();

      List<SongDTO> songs = this.songService.getAllSongs();

        model.addAttribute("songs", songs);

    //    model.addAttribute("totalTime", orders.stream()
        //        .map(orderDTO -> orderDTO.getCategory().getNeededTime())
         //       .reduce(Integer::sum).orElse(null));
        return "home";
    }
}
