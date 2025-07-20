package com.biat.analysefinanciere.repository;

import com.biat.analysefinanciere.entity.Rubrique;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubriqueRepository extends JpaRepository<Rubrique, Long> {

    
}