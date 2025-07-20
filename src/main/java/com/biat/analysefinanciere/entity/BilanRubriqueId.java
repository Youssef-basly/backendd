package com.biat.analysefinanciere.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BilanRubriqueId implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long bilanId;
    private Long rubriqueId;
    
    public BilanRubriqueId() {
    }
    
    public BilanRubriqueId(Long bilanId, Long rubriqueId) {
        this.bilanId = bilanId;
        this.rubriqueId = rubriqueId;
    }
    
    // Getters and Setters
    public Long getBilanId() {
        return bilanId;
    }

    public void setBilanId(Long bilanId) {
        this.bilanId = bilanId;
    }

    public Long getRubriqueId() {
        return rubriqueId;
    }

    public void setRubriqueId(Long rubriqueId) {
        this.rubriqueId = rubriqueId;
    }
    
    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BilanRubriqueId that = (BilanRubriqueId) o;
        return Objects.equals(bilanId, that.bilanId) &&
               Objects.equals(rubriqueId, that.rubriqueId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bilanId, rubriqueId);
    }
}
