package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.Farm;

/**
 * Criar Fazenda.
 */
public record CreatedFarm(String name, Double size) {

  /**
   * Entidade - Fazenda.
   *
   * @return the farm
   */
  public Farm toEntity() {
    return new Farm(name, size);
  }
}
