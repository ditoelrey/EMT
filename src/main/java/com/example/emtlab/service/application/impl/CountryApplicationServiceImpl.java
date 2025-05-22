package com.example.emtlab.service.application.impl;

import com.example.emtlab.dto.CreateCountryDto;
import com.example.emtlab.dto.DisplayCountryDto;
import com.example.emtlab.dto.DisplayGuestDto;
import com.example.emtlab.model.Country;
import com.example.emtlab.service.application.CountryApplicationService;
import com.example.emtlab.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {

        this.countryService = countryService;
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return countryService.findAll().stream().map(DisplayCountryDto::from).collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto countryDto) {


        return countryService.save(countryDto.toCountry()).map(DisplayCountryDto::from);
    }


    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto countryDto) {

        return countryService.update(id,countryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public void deleteById(Long id) {
        countryService.deleteById(id);
    }
}
