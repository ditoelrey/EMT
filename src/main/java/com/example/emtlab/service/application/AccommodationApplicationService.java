package com.example.emtlab.service.application;

import com.example.emtlab.dto.AccommodationPerCategoryDTO;
import com.example.emtlab.dto.CreateAccommodationDto;
import com.example.emtlab.dto.DisplayAccommodationDto;
import com.example.emtlab.model.projections.CategoryProjection;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {

    List<DisplayAccommodationDto> findAll();

    Optional<DisplayAccommodationDto> save(CreateAccommodationDto accommodationDto);

    Optional<DisplayAccommodationDto> findById(Long id);

    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto);

    void deleteById(Long id);

    List<AccommodationPerCategoryDTO> statistics();

    void rentAccommodation(Long id);




}
