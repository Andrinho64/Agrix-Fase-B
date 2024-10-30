package com.betrybe.agrix.service.exception;

/**
 * Exceção de uma fazenda não encontrada.
 */
public class FarmNotFoundException extends NotFoundException {

  /**
   * Instancia - uma nova Fazenda não encontrada.
   */
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
