package com.betrybe.agrix.repository;

import com.betrybe.agrix.model.Crop;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository interface - Crop entity.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

  /**
   * Encontrar Crops pelo id - Fazenda.
   *
   * @param farmId the farm id
   * @return the list of crops
   */
  List<Crop> findByFarmId(Long farmId);
}