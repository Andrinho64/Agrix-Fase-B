package com.betrybe.agrix.service;

import com.betrybe.agrix.model.Crop;
import com.betrybe.agrix.model.Fertilizer;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.repository.FertilizerRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The type Crop service.
 */
@Service
public class CropService {

  private CropRepository cropRepository;
  private FertilizerRepository fertilizerRepository;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository the crop repository
   * @param fertilizerRepository the fertilizer repository
   */
  @Autowired
  public CropService(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
    this.cropRepository = cropRepository;
    this.fertilizerRepository = fertilizerRepository;
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

  /**
   * Associate crop with fertilizer.
   *
   * @param cropId the crop id
   * @param fertilizerId the fertilizer id
   * @return the associated crop
   */
  public Crop associateCropWithFertilizer(Long cropId, Long fertilizerId) {
    Optional<Crop> cropOptional = cropRepository.findById(cropId);
    Optional<Fertilizer> fertilizerOptional = fertilizerRepository.findById(fertilizerId);

    if (cropOptional.isEmpty()) {
      throw new RuntimeException("Plantação não encontrada!");
    }

    if (fertilizerOptional.isEmpty()) {
      throw new RuntimeException("Fertilizante não encontrado!");
    }

    Crop crop = cropOptional.get();
    Fertilizer fertilizer = fertilizerOptional.get();

    crop.getFertilizers().add(fertilizer);
    fertilizer.getCrops().add(crop);

    cropRepository.save(crop);
    fertilizerRepository.save(fertilizer);

    return crop;
  }

  public List<Crop> findCropsByHarvestDateBetween(LocalDate start, LocalDate end) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findCropsByHarvestDateBetween'");
  }
}