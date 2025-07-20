package com.biat.analysefinanciere.controller;

import com.biat.analysefinanciere.entity.Rubrique;
import com.biat.analysefinanciere.repository.RubriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rubriques")
public class RubriqueController {

    @Autowired
    private RubriqueRepository rubriqueRepository;

    @PostMapping
    public Rubrique createRubrique(@RequestBody Rubrique rubrique) {
        return rubriqueRepository.save(rubrique);
    }

    @GetMapping
    public List<Rubrique> getAllRubriques() {
        return rubriqueRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<Rubrique> getRubriqueById(@PathVariable Long id) {
        return rubriqueRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
}


    @PutMapping("/{id}")
    public Rubrique updateRubrique(@PathVariable Long id, @RequestBody Rubrique updatedRubrique) {
        Rubrique rubrique = rubriqueRepository.findById(id).orElse(null);
        if (rubrique != null) {
            rubrique.setNom(updatedRubrique.getNom());
           
            rubrique.setType(updatedRubrique.getType());
            return rubriqueRepository.save(rubrique);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteRubrique(@PathVariable Long id) {
        rubriqueRepository.deleteById(id);
    }
    
}
