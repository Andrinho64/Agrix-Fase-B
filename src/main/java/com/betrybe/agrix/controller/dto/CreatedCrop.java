package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.Crop;
import com.betrybe.agrix.model.Farm;

/**
 * Tipo de Crop criada.
 */
public record CreatedCrop(String name, Double plantedArea) {

  /**
   * Para entidade Crop.
   *
   * @param farm the farm
   * @return the crop
   */
  public Crop toEntity(Farm farm) {
    return new Crop(name, plantedArea, farm);
  }
}