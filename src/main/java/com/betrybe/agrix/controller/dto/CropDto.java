package com.betrybe.agrix.controller.dto;

import java.time.LocalDate;

/**
 * The type Crop Dto.
 */
public class CropDto {

  private Long id;
  private String name;
  private double plantedArea;
  private LocalDate plantedDate;
  private LocalDate harvestDate;
  private Long farmId;

  /**
   * Instantiates a new Crop Dto.
   *
   * @param id the id
   * @param name the name
   * @param plantedArea the planted area
   * @param plantedDate the planted date
   * @param harvestDate the harvest date
   * @param farmId the farm id
   */
  public CropDto(
      Long id,
      String name,
      double plantedArea,
      LocalDate plantedDate,
      LocalDate harvestDate,
      Long farmId) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
    this.farmId = farmId;
  }

  // Getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  public Long getFarmId() {
    return farmId;
  }

  public void setFarmId(Long farmId) {
    this.farmId = farmId;
  }
}