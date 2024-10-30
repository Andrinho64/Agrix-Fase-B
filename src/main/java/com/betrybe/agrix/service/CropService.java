package com.betrybe.agrix.service;

import com.betrybe.agrix.model.Crop;
import com.betrybe.agrix.repository.CropRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Tipo - Crop service.
 */
@Service
public class CropService {

  private CropRepository cropRepository;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository the crop repository
   */
  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  /**
   * Save crop.
   *
   * @param crop the crop
   * @return the saved crop
   */
  public Crop saveCrop(Crop crop) {
    return cropRepository.save(crop);
  }

  /**
   * Pegar Crops pelo id Fazenda.
   *
   * @param farmId the farm id
   * @return the list of crops
   */
  public List<Crop> getCropsByFarmId(Long farmId) {
    return cropRepository.findByFarmId(farmId);
  }

  /**
   * Get all crops.
   *
   * @return the list of all crops
   */
  public List<Crop> getAllCrops() {
    return cropRepository.findAll();
  }

  /**
   * Get crop by id.
   *
   * @param id the id
   * @return the crop
   */
  public Optional<Crop> getCropById(Long id) {
    return cropRepository.findById(id);
  }
}