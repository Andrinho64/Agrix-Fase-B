package com.betrybe.agrix.model;

import com.betrybe.agrix.controller.dto.FertilizerDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Fertilizer - Type.
 */
@Entity
@Table(name = "fertilizers")
public class Fertilizer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String brand;

  @Column(nullable = false)
  private String composition;

  @ManyToMany(mappedBy = "fertilizers")
  private Set<Crop> crops = new HashSet<>();

  // Construtores, getters e setters
  public Fertilizer() {}

  /**
   * Instantiates a new Fertilizer.
   *
   * @param name the name
   * @param brand the brand
   * @param composition the composition
   */
  public Fertilizer(String name, String brand, String composition) {
    this.name = name;
    this.brand = brand;
    this.composition = composition;
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

  public Set<Crop> getCrops() {
    return crops;
  }

  public void setCrops(Set<Crop> crops) {
    this.crops = crops;
  }

  /**
   * Converts the Fertilizer entity to a Dto.
   *
   * @return the FertilizerDto
   */
  public FertilizerDto toDto() {
    return new FertilizerDto(id, name, brand, composition);
  }
}