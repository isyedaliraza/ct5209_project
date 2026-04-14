package com.github.isyedaliraza.ct5209_project.controller;

import com.github.isyedaliraza.ct5209_project.model.PetitionDTO;
import com.github.isyedaliraza.ct5209_project.service.PetitionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/petition/{id}")
    public String detail(@PathVariable Long id, Model model) {
        PetitionDTO petition = petitionService.findById(id);
        model.addAttribute("title", "Petitions | Detail");
        model.addAttribute("petition", petition);
        model.addAttribute("signatureCount", petition.getSignatures().size());
        return "detail";
    }

    @PostMapping("/petition/{id}/sign")
    public String sign(@PathVariable Long id, @RequestParam String name, @RequestParam String email,
                       RedirectAttributes redirectAttributes, Model model) {
        String error = null;
        if (name.isBlank()) {
            error = "Name is required";
        } else if (email.isBlank()) {
            error = "Email is required";
        }

        if (error != null) {
            redirectAttributes.addFlashAttribute("error", error);
            return "redirect:/petition/" + id;
        }

        petitionService.sign(id, name, email);
        redirectAttributes.addFlashAttribute("success", "Petition has been signed");
        return "redirect:/petition/" + id;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("title", "Petitions | New");
        return "create";
    }

    @PostMapping("/create")
    public String submit(@RequestParam String title, @RequestParam String description,
                         RedirectAttributes redirectAttributes, Model model) {
        String error = null;

        if (title.isBlank()) {
            error = "Title is required";
        } else if (description.isBlank()) {
            error = "Description is required";
        }

        if (error != null) {
            model.addAttribute("error", error);
            return "create";
        }

        petitionService.save(title, description);

        redirectAttributes.addFlashAttribute("success", "Petition has been created.");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) String query, Model model) {
        model.addAttribute("title", "Petitions | Search");

        if (query != null && !query.isBlank()) {
            List<PetitionDTO> results = petitionService.findByTitle(query);
            model.addAttribute("results", results);
            model.addAttribute("query", query);
        }

        return "search";
    }
}
