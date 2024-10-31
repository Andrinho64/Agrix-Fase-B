package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.model.Fertilizer;
import com.betrybe.agrix.service.FertilizerService;
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
 * The type Fertilizer controller.
 */
@RestController
@RequestMapping(value = "/fertilizers")
public class FertilizerController {

  private FertilizerService fertilizerService;

  /**
   * Instantiates a new Fertilizer controller.
   *
   * @param fertilizerService the fertilizer service
   */
  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * Create fertilizer response entity.
   *
   * @param fertilizer the fertilizer
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<FertilizerDto> createFertilizer(@RequestBody Fertilizer fertilizer) {
    Fertilizer newFertilizer = fertilizerService.saveFertilizer(fertilizer);
    return ResponseEntity.status(HttpStatus.CREATED).body(newFertilizer.toDto());
  }

  /**
   * Get all fertilizers response entity.
   *
   * @return the response entity
   */
  @GetMapping
  public ResponseEntity<List<FertilizerDto>> getAllFertilizers() {
    List<Fertilizer> fertilizers = fertilizerService.getAllFertilizers();
    List<FertilizerDto> fertilizerDtos = fertilizers.stream().map(Fertilizer::toDto).collect(
        Collectors.toList());
    return ResponseEntity.ok(fertilizerDtos);
  }

  /**
   * Get fertilizer by id response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @GetMapping("/{id}")
  public ResponseEntity<Object> getFertilizerById(@PathVariable Long id) {
    Optional<Fertilizer> fertilizer = fertilizerService.getFertilizerById(id);
    if (fertilizer.isPresent()) {
      return ResponseEntity.ok(fertilizer.get().toDto());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("{ \"message\": \"Fertilizante não encontrado!\" }");
    }
  }
}