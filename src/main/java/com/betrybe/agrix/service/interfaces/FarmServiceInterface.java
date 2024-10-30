package com.betrybe.agrix.service.interfaces;

import com.betrybe.agrix.model.Farm;
import java.util.List;
import java.util.Optional;

/**
 * The interface Farm service interface.
 */
public interface FarmServiceInterface {

  /**
   * Sets farm repository.
   *
   * @param farm the farm
   * @return the farm repository
   */
  Farm setFarmRepository(Farm farm);

  /**
   * Gets all farms.
   *
   * @return the list of farms
   */
  List<Farm> getAllFarms();

  /**
   * Gets farm by id.
   *
   * @param id the id
   * @return the farm
   */
  Optional<Farm> getFarmById(Long id);
}