package com.example.emtlab.service.application;

import com.example.emtlab.dto.CreateCountryDto;
import com.example.emtlab.dto.DisplayCountryDto;
import com.example.emtlab.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {

    List<DisplayCountryDto> findAll();

    Optional<DisplayCountryDto> findById(Long id);

    Optional<DisplayCountryDto> save(CreateCountryDto countryDto);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto countryDto);

    void deleteById(Long id);
}
