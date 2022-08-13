package com.softuni.battleShips.controllers;

import com.softuni.battleShips.models.dto.CreateShipDTO;
import com.softuni.battleShips.models.dto.StartBattleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BattleController {



    @ModelAttribute("startBattleDTO")
    public StartBattleDTO initBattleForm() {
        return new StartBattleDTO();
    }

    @PostMapping("/battle")
    public String battle(@Valid StartBattleDTO startBattleDTO,
                BindingResult bindingResult,
                RedirectAttributes redirectAttributes) {

        return "redirect:/home";
    }


}
