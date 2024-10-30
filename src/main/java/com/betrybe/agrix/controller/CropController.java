package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.model.Crop;
import com.betrybe.agrix.service.CropService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Type - Crop controller.
 */
@RestController
@RequestMapping(value = "/crops")
public class CropController {

  private CropService cropService;

  /**
   * Instancias - Nova Crop controller.
   *
   * @param cropService the crop service
   */
  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Get all crops response entity.
   *
   * @return the response entity
   */
  @GetMapping
  public ResponseEntity<List<CropDto>> getAllCrops() {
    List<Crop> crops = cropService.getAllCrops();
    List<CropDto> cropDtos = crops.stream().map(Crop::toDto).collect(Collectors.toList());
    return ResponseEntity.ok(cropDtos);
  }

  /**
   * Get crop by id response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @GetMapping("/{id}")
  public ResponseEntity<Object> getCropById(@PathVariable Long id) {
    Optional<Crop> crop = cropService.getCropById(id);
    if (crop.isPresent()) {
      return ResponseEntity.ok(crop.get().toDto());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("{ \"message\": \"Plantação não encontrada!\" }");
    }
  }
}