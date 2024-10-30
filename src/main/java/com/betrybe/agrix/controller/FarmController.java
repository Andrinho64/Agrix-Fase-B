package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CreatedCrop;
import com.betrybe.agrix.controller.dto.CreatedFarm;
import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.model.Crop;
import com.betrybe.agrix.model.Farm;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Type - Farm controller.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private FarmService farmService;
  private CropService cropService;

  /**
   * Instantiates - new Farm controller.
   *
   * @param farmService the farm service
   * @param cropService the crop service
   */
  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  /**
   * Resposta de entidade ao criar fazenda.
   *
   * @param farm the farm
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<Farm> createFarm(@RequestBody CreatedFarm farm) {
    Farm newFarm = farmService.setFarmRepository(farm.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }

  /**
   * Get all farms response entity.
   *
   * @return the response entity
   */
  @GetMapping
  public ResponseEntity<List<Farm>> getAllFarms() {
    List<Farm> farms = farmService.getAllFarms();
    return ResponseEntity.ok(farms);
  }

  /**
   * Get farm by id response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @GetMapping("/{id}")
  public ResponseEntity<Object> getFarmById(@PathVariable Long id) {
    Optional<Farm> farm = farmService.getFarmById(id);
    if (farm.isPresent()) {
      return ResponseEntity.ok(farm.get());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("{ \"message\": \"Fazenda não encontrada!\" }");
    }
  }

  /**
   * Create crop response entity.
   *
   * @param farmId the farm id
   * @param crop   the crop
   * @return the response entity
   */
  @PostMapping("/{farmId}/crops")
  public ResponseEntity<Object> 
      createCrop(@PathVariable Long farmId, @RequestBody CreatedCrop crop) {
    Optional<Farm> farm = farmService.getFarmById(farmId);
    if (farm.isPresent()) {
      Crop newCrop = cropService.saveCrop(crop.toEntity(farm.get()));
      return ResponseEntity.status(HttpStatus.CREATED).body(newCrop.toDto());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("{ \"message\": \"Fazenda não encontrada!\" }");
    }
  }

  /**
   * Get crops by farm id response entity.
   *
   * @param farmId the farm id
   * @return the response entity
   */
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<Object> getCropsByFarmId(@PathVariable Long farmId) {
    Optional<Farm> farm = farmService.getFarmById(farmId);
    if (farm.isPresent()) {
      List<Crop> crops = cropService.getCropsByFarmId(farmId);
      List<CropDto> cropDtos = crops.stream().map(Crop::toDto).collect(Collectors.toList());
      return ResponseEntity.ok(cropDtos);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("{ \"message\": \"Fazenda não encontrada!\" }");
    }
  }
}