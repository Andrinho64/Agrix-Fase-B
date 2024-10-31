package com.betrybe.agrix.service;

import com.betrybe.agrix.model.Fertilizer;
import com.betrybe.agrix.repository.FertilizerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fertilizer service.
 */
@Service
public class FertilizerService {

  private FertilizerRepository fertilizerRepository;

  /**
   * Instantiates a new Fertilizer service.
   *
   * @param fertilizerRepository the fertilizer repository
   */
  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Save fertilizer.
   *
   * @param fertilizer the fertilizer
   * @return the saved fertilizer
   */
  public Fertilizer saveFertilizer(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  /**
   * Get all fertilizers.
   *
   * @return the list of all fertilizers
   */
  public List<Fertilizer> getAllFertilizers() {
    return fertilizerRepository.findAll();
  }

  /**
   * Get fertilizer by id.
   *
   * @param id the id
   * @return the fertilizer
   */
  public Optional<Fertilizer> getFertilizerById(Long id) {
    return fertilizerRepository.findById(id);
  }
}