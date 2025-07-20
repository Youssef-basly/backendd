package com.biat.analysefinanciere.entity;

import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.biat.analysefinanciere.entity.Entreprise;

@Entity
public class Bilan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bilan_seq")
    @SequenceGenerator(name = "bilan_seq", sequenceName = "BILAN_SEQ", allocationSize = 1)
    private Long id;

    private Long clientId;
    private int ANNEE;
    private String typeBilan;
    private double TOTAL_PASSIF;
    private double TOTAL_ACTIF;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID", nullable = true) // temporairement
    private Utilisateur utilisateur;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ENTREPRISE_ID", nullable = false)
    private Entreprise entreprise;
    
    @JsonIgnore
    @OneToMany(mappedBy = "bilan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ratio> ratios;
    
    @JsonIgnore
    @OneToMany(mappedBy = "bilan", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BilanRubrique> rubriques = new HashSet<>();
    
    // Helper methods for managing rubriques
    public void addRubrique(Rubrique rubrique, double valeur) {
        BilanRubrique bilanRubrique = new BilanRubrique();
        bilanRubrique.setBilanAndRubrique(this, rubrique);
        bilanRubrique.setValeur(valeur);
        rubriques.add(bilanRubrique);
    }
    
    public void removeRubrique(Rubrique rubrique) {
        for (Iterator<BilanRubrique> iterator = rubriques.iterator(); iterator.hasNext();) {
            BilanRubrique br = iterator.next();
            if (br.getBilan().equals(this) && br.getRubrique().equals(rubrique)) {
                iterator.remove();
                br.setBilan(null);
                br.setRubrique(null);
            }
        }
    }

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public int getAnnee() { return ANNEE; }
    public void setAnnee(int annee) { this.ANNEE = annee; }

    public String getTypeBilan() { return typeBilan; }
    public void setTypeBilan(String typeBilan) { this.typeBilan = typeBilan; }

    public double getTotalActif() { return TOTAL_ACTIF; }
    public void setTotalActif(double totalActif) { this.TOTAL_ACTIF = totalActif; }

    public double getTotalPassif() { return TOTAL_PASSIF; }
    public void setTotalPassif(double totalPassif) { this.TOTAL_PASSIF = totalPassif; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }


        public List<Ratio> getRatios() { return ratios; }
    public void setRatios(List<Ratio> ratios) { this.ratios = ratios; }
    public Entreprise getEntreprise() {
    return entreprise;
}

public void setEntreprise(Entreprise entreprise) {
    this.entreprise = entreprise;
}

    public Set<BilanRubrique> getRubriques() {
        return rubriques;
    }
    
    public void setRubriques(Set<BilanRubrique> rubriques) {
        this.rubriques = rubriques;
    }

}
