package com.softuni.shoppingList.controllers;

import com.softuni.shoppingList.models.dtos.AddSongDTO;
import com.softuni.shoppingList.services.SongService;
import com.softuni.shoppingList.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {
    private final SongService songService;

    private final UserService userService;

    public SongController(SongService songService, UserService userService) {
        this.songService = songService;
        this.userService = userService;
    }

    @ModelAttribute("addSongDTO")
    public AddSongDTO initCreateShipDTO() {
        return new AddSongDTO();
    }

    @GetMapping("/songs/add")
    public String songs() {
        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }

        return "song-add";
    }

    @PostMapping("/songs/add")
    public String songs(@Valid AddSongDTO addSongDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (!this.userService.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !this.songService.addSong(addSongDTO)) {
            redirectAttributes.addFlashAttribute("addSongDTO", addSongDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addSongDTO", bindingResult);

            return "redirect:/songs/add";
        }

        return "redirect:/home";
    }
}
