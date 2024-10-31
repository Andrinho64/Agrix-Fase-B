package com.betrybe.agrix.repository;

import com.betrybe.agrix.model.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Fertilizer entity.
 */
@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
}