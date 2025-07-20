package com.biat.analysefinanciere.service.impl;

import com.biat.analysefinanciere.entity.Entreprise;
import com.biat.analysefinanciere.repository.EntrepriseRepository;
import com.biat.analysefinanciere.service.EntrepriseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public Entreprise ajouterEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public List<Entreprise> listerEntreprises() {
        return entrepriseRepository.findAll();
    }



    // Helper method to find by entity ID
    public Entreprise getEntrepriseById(Long id) {
        return entrepriseRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }

    @Override
public Entreprise save(Entreprise entreprise) {
    return entrepriseRepository.save(entreprise);
}
}
