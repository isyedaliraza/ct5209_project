package com.github.isyedaliraza.ct5209_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetitionsController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "Petitions | Home");
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
