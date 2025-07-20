package com.biat.analysefinanciere.repository;

import com.biat.analysefinanciere.entity.Bilan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BilanRepository extends JpaRepository<Bilan, Long> {
    List<Bilan> findByUtilisateurId(Long utilisateurId);
    
    List<Bilan> findByEntrepriseId(Long entrepriseId);
}
