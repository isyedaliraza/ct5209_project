package com.github.isyedaliraza.ct5209_project.controller;

import com.github.isyedaliraza.ct5209_project.model.PetitionDTO;
import com.github.isyedaliraza.ct5209_project.service.PetitionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PetitionsController {
    private final PetitionService petitionService;

    public PetitionsController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    @GetMapping
    public String index(Model model) {
        List<PetitionDTO> petitions = petitionService.findAll();
        model.addAttribute("title", "Petitions | Home");
        model.addAttribute("petitions", petitions);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("title", "Petitions | New");
        return "create";
    }

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("title", "Petitions | Search");
        return "search";
    }
}
