package com.example.emtlab.service.domain;

import com.example.emtlab.dto.AccommodationPerCategoryDTO;
import com.example.emtlab.dto.AccommodationsByHostDTO;
import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.projections.CategoryProjection;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> save(Accommodation accommodation);

    Optional<Accommodation> findById(Long id);

    Optional<Accommodation> update(Long id, Accommodation category);

    void deleteById(Long id);
    List<AccommodationPerCategoryDTO> statistics();

    void rentAccommodation(Long id);

    void refreshAccommodationsByHostMaterializedView();

    List<AccommodationsByHostDTO> getAccommodationsCountByHost();




}
