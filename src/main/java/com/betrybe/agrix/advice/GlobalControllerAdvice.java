package com.betrybe.agrix.advice;

import com.betrybe.agrix.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * O tipo de conselho do controlador global.
 */
@ControllerAdvice
public class GlobalControllerAdvice {

  /**
   * Entidade - resposta de exceção.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler
  public ResponseEntity<String> handleException(NotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(ex.getMessage());
  }
}
