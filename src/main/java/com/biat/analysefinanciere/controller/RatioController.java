package com.biat.analysefinanciere.controller;

import com.biat.analysefinanciere.entity.Ratio;
import com.biat.analysefinanciere.repository.RatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratios")
public class RatioController {

    @Autowired
    private RatioRepository ratioRepository;

    // Créer un ratio
    @PostMapping
    public Ratio createRatio(@RequestBody Ratio ratio) {
        return ratioRepository.save(ratio);
    }

    // Récupérer tous les ratios
    @GetMapping
    public List<Ratio> getAllRatios() {
        return ratioRepository.findAll();
    }

    // Récupérer un ratio par ID
   @GetMapping("/{id}")
public ResponseEntity<Ratio> getRatioById(@PathVariable Long id) {
    return ratioRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
}


    // Mettre à jour un ratio
    @PutMapping("/{id}")
    public Ratio updateRatio(@PathVariable Long id, @RequestBody Ratio updatedRatio) {
        return ratioRepository.findById(id).map(ratio -> {
            ratio.setNom(updatedRatio.getNom());
            ratio.setFormule(updatedRatio.getFormule());
            return ratioRepository.save(ratio);
        }).orElse(null);
    }
    

    // Supprimer un ratio
    @DeleteMapping("/{id}")
    public void deleteRatio(@PathVariable Long id) {
        ratioRepository.deleteById(id);
    }
}
