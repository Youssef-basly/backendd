package com.biat.analysefinanciere.controller;

import com.biat.analysefinanciere.entity.Bilan;
import com.biat.analysefinanciere.entity.Utilisateur;
import com.biat.analysefinanciere.repository.BilanRepository;
import com.biat.analysefinanciere.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bilans")
public class BilanController {

    @Autowired
    private BilanRepository bilanRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public List<Bilan> getAllBilans() {
        return bilanRepository.findAll();
    }

    @PostMapping
    public Bilan createBilan(@RequestBody Bilan bilan) {
        if (bilan.getUtilisateur() == null || bilan.getUtilisateur().getId() == null) {
            throw new IllegalArgumentException("Utilisateur ID requis");
        }

        Utilisateur utilisateur = utilisateurRepository.findById(bilan.getUtilisateur().getId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        bilan.setUtilisateur(utilisateur);

        if (Math.abs(bilan.getTotalActif() - bilan.getTotalPassif()) > 1e-6) {
            throw new IllegalArgumentException("L'actif total doit être égal au passif total !");
        }

        return bilanRepository.save(bilan);
    }

    @PutMapping("/{id}")
    public Bilan updateBilan(@PathVariable Long id, @RequestParam Long utilisateurId, @RequestBody Bilan updatedBilan) {
        Optional<Bilan> existingBilan = bilanRepository.findById(id);
        if (existingBilan.isPresent() && existingBilan.get().getUtilisateur().getId().equals(utilisateurId)) {
            Bilan bilan = existingBilan.get();
            bilan.setClientId(updatedBilan.getClientId());
            bilan.setAnnee(updatedBilan.getAnnee());
            bilan.setTypeBilan(updatedBilan.getTypeBilan());
            bilan.setTotalActif(updatedBilan.getTotalActif());
            bilan.setTotalPassif(updatedBilan.getTotalPassif());
            return bilanRepository.save(bilan);
        }
        throw new IllegalArgumentException("Bilan non trouvé ou accès refusé.");
    }

    @DeleteMapping("/{id}")
    public void deleteBilan(@PathVariable Long id, @RequestParam Long utilisateurId) {
        Optional<Bilan> bilan = bilanRepository.findById(id);
        if (bilan.isPresent() && bilan.get().getUtilisateur().getId().equals(utilisateurId)) {
            bilanRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Bilan non trouvé ou accès refusé.");
        }
    }
    
    @GetMapping("/entreprise/{entrepriseId}")
    public List<Bilan> getBilansByEntrepriseId(@PathVariable Long entrepriseId) {
        return bilanRepository.findByEntrepriseId(entrepriseId);
    }
}
