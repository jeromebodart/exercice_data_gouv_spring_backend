package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.entreprise.Entreprise;
import com.example.service.EntrepriseService;

@RestController
@RequestMapping("/entreprises")
public class EntreprisesController {
    @Autowired
    private EntrepriseService entrepriseService;

    @GetMapping
    public List<Entreprise> index(Model model) {
    	return entrepriseService.findAll();
//        model.addAttribute("entreprises", entrepriseService.findAll());
//        return "entreprises/index";
    }

    @GetMapping("new")
    public String newEntreprise() {
        return "entreprises/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("entreprise", entrepriseService.findOne(id));
        return "entreprises/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("entreprise", entrepriseService.findOne(id));
        model.addAttribute("entreprises.siege", entrepriseService.findOne(id).getSiege());
        return "entreprises/show";
    }

    @PostMapping
    public String create(@ModelAttribute Entreprise entreprise) {
    	entrepriseService.save(entreprise);
        return "redirect:/entreprises";
    }
    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Entreprise entreprise) {
    	entreprise.setId(id);
    	entrepriseService.update(entreprise);
        return "redirect:/entreprises";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
    	entrepriseService.delete(id);
        return "redirect:/entreprises";
    }
}
