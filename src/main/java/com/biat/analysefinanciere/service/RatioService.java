package com.biat.analysefinanciere.service;

import com.biat.analysefinanciere.entity.Bilan;
import com.biat.analysefinanciere.entity.Ratio;
import com.biat.analysefinanciere.repository.BilanRepository;
import com.biat.analysefinanciere.repository.RatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatioService {

    @Autowired
    private RatioRepository ratioRepository;

    @Autowired
    private BilanRepository bilanRepository;

    public List<Ratio> getAllRatios() {
        return ratioRepository.findAll();
    }

    public List<Ratio> getRatiosByBilanId(Long bilanId) {
        return ratioRepository.findByBilanId(bilanId);
    }

    public Optional<Ratio> getRatioById(Long id) {
        return ratioRepository.findById(id);
    }

    public Ratio createRatio(Long bilanId, Ratio ratio) {
        Bilan bilan = bilanRepository.findById(bilanId)
                .orElseThrow(() -> new IllegalArgumentException("Bilan non trouvé"));
        return ratioRepository.save(ratio);
    }

    public Ratio updateRatio(Long id, Ratio updatedRatio) {
        return ratioRepository.findById(id).map(ratio -> {
            ratio.setNom(updatedRatio.getNom());
            return ratioRepository.save(ratio);
        }).orElseThrow(() -> new IllegalArgumentException("Ratio non trouvé"));
    }

    public void deleteRatio(Long id) {
        ratioRepository.deleteById(id);
    }
    public Double calculerRatio(Double valeur1, Double valeur2) {
    if (valeur2 != null && valeur2 != 0) {
        return valeur1 / valeur2;
    } else {
        return null; // ou lancer une exception
    }
}

}
