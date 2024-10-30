package com.betrybe.agrix.model;

import com.betrybe.agrix.controller.dto.CropDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 * Crop - Type.
 */
@Entity
@Table(name = "crops")
public class Crop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private double plantedArea;

  @Column(nullable = false)
  private LocalDate plantedDate;

  @Column(nullable = false)
  private LocalDate harvestDate;

  @ManyToOne
  @JoinColumn(name = "farm_id", nullable = false)
  private Farm farm;

  // Construtores, getters e setters
  public Crop() {}

  /**
   * Instantiates a new Crop.
   *
   * @param name the name
   * @param plantedArea the planted area
   * @param plantedDate the planted date
   * @param harvestDate the harvest date
   * @param farm the farm
   */
  public Crop(
      String name,
      double plantedArea,
      LocalDate plantedDate,
      LocalDate harvestDate,
      Farm farm) {
    this.name = name;
    this.plantedArea = plantedArea;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
    this.farm = farm;
  }

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

  public Farm getFarm() {
    return farm;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  /**
   * Converts the Crop entity to a Dto.
   *
   * @return the CropDto
   */
  public CropDto toDto() {
    return new CropDto(id, name, plantedArea, plantedDate, harvestDate, farm.getId());
  }
}