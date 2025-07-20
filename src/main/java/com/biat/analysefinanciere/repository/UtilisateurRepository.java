package com.biat.analysefinanciere.repository;

import com.biat.analysefinanciere.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email); // 👈 ajoute cette ligne
}
