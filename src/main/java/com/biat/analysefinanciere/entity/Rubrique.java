package com.biat.analysefinanciere.entity;


import jakarta.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RUBRIQUE") // <-- AJOUTÉ CETTE LIGNE POUR ORACLE
public class Rubrique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
   
    private String type;

    @OneToMany(mappedBy = "rubrique", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<BilanRubrique> bilans = new HashSet<>();
    
    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }


    public Set<BilanRubrique> getBilans() {
        return bilans;
    }


    public void setBilans(Set<BilanRubrique> bilans) {
        this.bilans = bilans;
    }
}
