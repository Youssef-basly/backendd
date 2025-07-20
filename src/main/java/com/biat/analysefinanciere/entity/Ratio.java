package com.biat.analysefinanciere.entity;

import jakarta.persistence.*;
@Entity
public class Ratio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratio_seq_gen")
    @SequenceGenerator(name = "ratio_seq_gen", sequenceName = "RATIO_SEQ", allocationSize = 1)
    private Long id;

    private String nom;
    private String formule;

    @ManyToOne
    @JoinColumn(name = "bilan_id", nullable = true)
    private Bilan bilan;

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getFormule() { return formule; }
    public void setFormule(String formule) { this.formule = formule; }

    public Bilan getBilan() { return bilan; }
    public void setBilan(Bilan bilan) { this.bilan = bilan; }
}
