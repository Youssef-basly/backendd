package com.biat.analysefinanciere.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ENTREPRISE")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Column(name = "TYPE_ENTREPRISE")
    private String typeEntreprise;

    @Column(name = "CA_TTC")
    private Double caTtc;

    // Relation : une entreprise a plusieurs bilans
    @JsonIgnore
    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
    private List<Bilan> bilans;


    @Column(name = "RAISON_SOCIALE")
private String raisonSociale;

public String getRaisonSociale() {
    return raisonSociale;
}

public void setRaisonSociale(String raisonSociale) {
    this.raisonSociale = raisonSociale;
}

@Column(name = "RNE")
private String rne;

public String getRne() {
    return rne;
}

public void setRne(String rne) {
    this.rne = rne;
}


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeEntreprise() {
        return typeEntreprise;
    }

    public void setTypeEntreprise(String typeEntreprise) {
        this.typeEntreprise = typeEntreprise;
    }

    public Double getCaTtc() {
        return caTtc;
    }

    public void setCaTtc(Double caTtc) {
        this.caTtc = caTtc;
    }

    public List<Bilan> getBilans() {
        return bilans;
    }

    public void setBilans(List<Bilan> bilans) {
        this.bilans = bilans;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
}
