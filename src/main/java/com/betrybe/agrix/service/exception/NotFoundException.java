package com.betrybe.agrix.service.exception;

/**
 * Tipo não encontrado.
 */
public class NotFoundException extends Exception {

  /**
   * Instancias não encontradas.
   *
   * @param message the message
   */
  public NotFoundException(String message) {
    super(message);
  }
}
