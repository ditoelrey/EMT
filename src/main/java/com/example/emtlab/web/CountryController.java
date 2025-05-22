package com.example.emtlab.web;

import com.example.emtlab.dto.CreateCountryDto;
import com.example.emtlab.dto.DisplayCountryDto;
import com.example.emtlab.service.application.CountryApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@Tag(name = "Country Controller", description = "Endpoints for managing countries")
public class CountryController {

    CountryApplicationService countryApplicationService;

    public CountryController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping
    @Operation(summary = "Get all countries", description = "Fetches all countries from the database")
    public List<DisplayCountryDto> findAll() {
        return countryApplicationService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get country by ID", description = "Returns a single country based on its ID")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id) {
        return countryApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Add new country", description = "Creates a new country entry")
    public ResponseEntity<DisplayCountryDto> save(@RequestBody CreateCountryDto country) {
        return countryApplicationService.save(country)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit a country", description = "Updates an existing country by ID")
    public ResponseEntity<DisplayCountryDto> update(@PathVariable Long id, @RequestBody CreateCountryDto country) {
        return countryApplicationService.update(id, country)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a country", description = "Deletes a country by ID")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (countryApplicationService.findById(id).isPresent()) {
            countryApplicationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
