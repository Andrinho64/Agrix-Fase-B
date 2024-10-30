package com.betrybe.agrix.controller.dto;

/**
 * Tipo - Crop Dto.
 */
public class CropDto {

  private Long id;
  private String name;
  private double plantedArea;
  private Long farmId;

  /**
   * Instancias de uma nova Crop Dto.
   *
   * @param id          the id
   * @param name        the name
   * @param plantedArea the planted area
   * @param farmId      the farm id
   */
  public CropDto(Long id, String name, double plantedArea, Long farmId) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
    this.farmId = farmId;
  }

  // Getters & setters
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

  public Long getFarmId() {
    return farmId;
  }

  public void setFarmId(Long farmId) {
    this.farmId = farmId;
  }
}