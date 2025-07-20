package com.biat.analysefinanciere.service;

import com.biat.analysefinanciere.entity.Rubrique;
import com.biat.analysefinanciere.repository.RubriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculRubriqueService {

    @Autowired
    private RubriqueRepository rubriqueRepository;

    public Map<Long, Double> calculerValeursComposees(Map<Long, Double> valeursSimples) {
        Map<Long, Double> resultat = new HashMap<>(valeursSimples);
        List<Rubrique> toutesRubriques = rubriqueRepository.findAll();
        
        toutesRubriques.stream()
            .filter(r -> r.getType() == Rubrique.TypeRubrique.SOUS_TOTAL || 
                         r.getType() == Rubrique.TypeRubrique.TOTAL)
            .forEach(rubrique -> {
                double valeur = calculerValeurRubrique(rubrique, resultat);
                resultat.put(rubrique.getId(), valeur);
            });
        
        return resultat;
    }

    private double calculerValeurRubrique(Rubrique rubrique, Map<Long, Double> valeurs) {
        if (rubrique.getType() == Rubrique.TypeRubrique.SIMPLE) {
            return valeurs.getOrDefault(rubrique.getId(), 0.0);
        }
        
        return rubrique.getEnfants().stream()
            .mapToDouble(e -> calculerValeurRubrique(e, valeurs))
            .sum();
    }
}