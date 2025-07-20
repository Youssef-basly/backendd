package com.biat.analysefinanciere.repository;

import com.biat.analysefinanciere.entity.Ratio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatioRepository extends JpaRepository<Ratio, Long> {
    List<Ratio> findByBilanId(Long bilanId);
}
