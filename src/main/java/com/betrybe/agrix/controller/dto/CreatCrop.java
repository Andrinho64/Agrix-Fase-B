package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.Crop;
import com.betrybe.agrix.model.Farm;

/**
 * Tipo de criar Crop.
 */
public record CreatCrop(String name, Double plantedArea) {

  /**
   * Entidade Crop.
   *
   * @param farm the farm
   * @return the crop
   */
  public Crop toEntity(Farm farm) {
    return new Crop(name, plantedArea, farm);
  }
}