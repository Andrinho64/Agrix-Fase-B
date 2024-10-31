package com.betrybe.agrix.controller.dto;

/**
 * The type Fertilizer Dto.
 */
public class FertilizerDto {

  private Long id;
  private String name;
  private String brand;
  private String composition;

  /**
   * Instantiates a new Fertilizer Dto.
   *
   * @param id the id
   * @param name the name
   * @param brand the brand
   * @param composition the composition
   */
  public FertilizerDto(Long id, String name, String brand, String composition) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.composition = composition;
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

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getComposition() {
    return composition;
  }

  public void setComposition(String composition) {
    this.composition = composition;
  }
}