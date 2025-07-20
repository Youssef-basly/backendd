package com.biat.analysefinanciere.repository;

import com.biat.analysefinanciere.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    // Optional<Entreprise> findByIdClient(String idClient);
    void deleteById(Long id);
}
