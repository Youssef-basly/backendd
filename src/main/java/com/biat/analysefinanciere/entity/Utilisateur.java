package com.biat.analysefinanciere.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String nom;
    private String prenom;
    private String email;
    private String role;


    @Column(name = "MOTDEPASSE")
    private String motdepasse;


    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotdepasse() {
    return motdepasse;
}

public void setMotdepasse(String motdepasse) {
    this.motdepasse = motdepasse;
}

   public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
