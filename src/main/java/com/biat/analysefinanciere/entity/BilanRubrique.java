package com.biat.analysefinanciere.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "BILAN_RUBRIQUE")
public class BilanRubrique {
    
    @EmbeddedId
    private BilanRubriqueId id;
    
    @ManyToOne
    @MapsId("bilanId")
    @JoinColumn(name = "bilan_id")
    @JsonIgnore
    private Bilan bilan;
    
    @ManyToOne
    @MapsId("rubriqueId")
    @JoinColumn(name = "rubrique_id")
    @JsonIgnore
    private Rubrique rubrique;
    
    private double valeur;
    
    // Getters and Setters
    public BilanRubriqueId getId() {
        return id;
    }

    public void setId(BilanRubriqueId id) {
        this.id = id;
    }

    public Bilan getBilan() {
        return bilan;
    }

    public void setBilan(Bilan bilan) {
        this.bilan = bilan;
    }

    public Rubrique getRubrique() {
        return rubrique;
    }

    public void setRubrique(Rubrique rubrique) {
        this.rubrique = rubrique;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    
    // Helper method to create composite key
    public void setBilanAndRubrique(Bilan bilan, Rubrique rubrique) {
        this.bilan = bilan;
        this.rubrique = rubrique;
        this.id = new BilanRubriqueId(bilan.getId(), rubrique.getId());
    }
}
