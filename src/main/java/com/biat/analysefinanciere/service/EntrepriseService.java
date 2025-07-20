package com.biat.analysefinanciere.service;

import com.biat.analysefinanciere.entity.Entreprise;
import java.util.List;

public interface EntrepriseService {
    Entreprise ajouterEntreprise(Entreprise entreprise);
    List<Entreprise> listerEntreprises();
    Entreprise getEntrepriseById(Long id);
    void supprimerEntreprise(Long id);
    Entreprise save(Entreprise entreprise);
}
