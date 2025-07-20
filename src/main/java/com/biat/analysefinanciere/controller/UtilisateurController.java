package com.biat.analysefinanciere.controller;
import com.biat.analysefinanciere.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.biat.analysefinanciere.entity.Utilisateur;
import com.biat.analysefinanciere.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAll() {
        return utilisateurService.getAll();
    }

    @GetMapping("/{id}")
    public Utilisateur getById(@PathVariable Long id) {
        return utilisateurService.getById(id);
    }

    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.save(utilisateur);
    }

    @PutMapping("/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        utilisateur.setId(id);
        return utilisateurService.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utilisateurService.delete(id);
    }
    public UtilisateurController() {
        System.out.println("🚀 UtilisateurController chargé !");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Utilisateur utilisateur = utilisateurService.findByEmail(loginRequest.getEmail());

        if (utilisateur != null && utilisateur.getMotdepasse().equals(loginRequest.getMotdepasse())) {
            return ResponseEntity.ok(utilisateur); // ou retourner un token plus tard
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrect");
     }
    }
}