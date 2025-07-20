package com.biat.analysefinanciere.service;

import com.biat.analysefinanciere.entity.Bilan;
import com.biat.analysefinanciere.repository.BilanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilanService {
    @Autowired
    private BilanRepository bilanRepository;

    public List<Bilan> getAllBilans() {
        return bilanRepository.findAll();
    }

    public Optional<Bilan> getBilanById(Long id) {
        return bilanRepository.findById(id);
    }

    
    public Bilan createBilan(Bilan bilan) {
        final double EPSILON = 1e-6;  // La tolérance à utiliser pour comparer les doubles
        if (Math.abs(bilan.getTotalActif() - bilan.getTotalPassif()) > EPSILON) {
            throw new IllegalArgumentException("L'actif total doit être égal au passif total !");
        }
        return bilanRepository.save(bilan);
    }
    

    public Bilan updateBilan(Long id, Bilan updatedBilan) {
        return bilanRepository.findById(id).map(bilan -> {
            bilan.setClientId(updatedBilan.getClientId());
            bilan.setAnnee(updatedBilan.getAnnee());
            bilan.setTypeBilan(updatedBilan.getTypeBilan());
            return bilanRepository.save(bilan);
        }).orElse(null);
    }

    public void deleteBilan(Long id) {
        bilanRepository.deleteById(id);
    }
    
}
