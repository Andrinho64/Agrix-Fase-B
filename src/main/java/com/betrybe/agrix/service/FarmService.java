package com.betrybe.agrix.service;

import com.betrybe.agrix.model.Farm;
import com.betrybe.agrix.repository.FarmRepository;
import com.betrybe.agrix.service.interfaces.FarmServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Tipo de serviço de Fazenda.
 */
@Service
public class FarmService implements FarmServiceInterface {

  private FarmRepository farmRepository;

  /**
   * Instancias de novo serviço de fazenda.
   *
   * @param farmRepository the farm repository
   */
  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  @Override
  public Farm setFarmRepository(Farm farm) {
    return farmRepository.save(farm);
  }

  @Override
  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  @Override
  public Optional<Farm> getFarmById(Long id) {
    return farmRepository.findById(id);
  }
}