package com.biat.analysefinanciere.controller;

import com.biat.analysefinanciere.entity.Entreprise;
import com.biat.analysefinanciere.service.EntrepriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @PostMapping
    public Entreprise ajouterEntreprise(@RequestBody Entreprise entreprise) {
        return entrepriseService.ajouterEntreprise(entreprise);
    }

    @GetMapping
    public List<Entreprise> listerEntreprises() {
        return entrepriseService.listerEntreprises();
    }

    @GetMapping("/{id}")
    public Entreprise getEntreprise(@PathVariable Long id) {
        return entrepriseService.getEntrepriseById(id);
    }

    @DeleteMapping("/{id}")
public void supprimerEntreprise(@PathVariable Long id) {
    entrepriseService.supprimerEntreprise(id);
}

@PutMapping("/{id}")
public Entreprise update(@PathVariable Long id, @RequestBody Entreprise entreprise) {
    entreprise.setId(id);
    return entrepriseService.save(entreprise);
}

}
