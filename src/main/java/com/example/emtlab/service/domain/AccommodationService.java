package com.example.emtlab.service.domain;

import com.example.emtlab.model.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> save(Accommodation accommodation);

    Optional<Accommodation> findById(Long id);

    Optional<Accommodation> update(Long id, Accommodation category);

    void deleteById(Long id);


}
