package com.example.emtlab.web;


import com.example.emtlab.dto.CreateAccommodationDto;
import com.example.emtlab.dto.DisplayAccommodationDto;
import com.example.emtlab.model.Accommodation;
import com.example.emtlab.service.application.AccommodationApplicationService;
import com.example.emtlab.service.domain.AccommodationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@Tag(name = "Accommodation Controller", description = "CRUD operations for accommodations")
public class AccommodationController {


    private final AccommodationApplicationService accommodationApplicationService;

    public AccommodationController(AccommodationApplicationService accommodationApplicationService) {
        this.accommodationApplicationService = accommodationApplicationService;
    }

    @GetMapping
    @Operation(summary = "Get all accommodations", description = "Fetches all accommodations from the database")
    public List<DisplayAccommodationDto> findAll() {
        return accommodationApplicationService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get accommodation by ID", description = "Returns a single accommodation based on its ID")
    public ResponseEntity<DisplayAccommodationDto> findById(@PathVariable Long id) {
        return accommodationApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Add new accommodation", description = "Creates a new accommodation entry")
    public ResponseEntity<DisplayAccommodationDto> save(@RequestBody CreateAccommodationDto accommodation) {
        return accommodationApplicationService.save(accommodation)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit an accommodation", description = "Updates an existing accommodation by ID")
    public ResponseEntity<DisplayAccommodationDto> update(@PathVariable Long id, @RequestBody CreateAccommodationDto accommodation) {
        return accommodationApplicationService.update(id, accommodation)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete an accommodation", description = "Deletes an accommodation by ID")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (accommodationApplicationService.findById(id).isPresent()) {
            accommodationApplicationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
