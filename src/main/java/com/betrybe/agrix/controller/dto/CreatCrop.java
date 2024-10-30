package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.Crop;
import com.betrybe.agrix.model.Farm;
import java.time.LocalDate;

/**
 * The type Created crop.
 */
public record CreatCrop(
    String name, Double plantedArea, LocalDate plantedDate, LocalDate harvestDate) {

  /**
   * To entity crop.
   *
   * @param farm the farm
   * @return the crop
   */
  public Crop toEntity(Farm farm) {
    return new Crop(name, plantedArea, plantedDate, harvestDate, farm);
  }
}