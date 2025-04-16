package com.example.emtlab.dto;

import com.example.emtlab.model.Country;
import com.example.emtlab.model.Guest;
import com.example.emtlab.model.Host;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayCountryDto(


        Long id,
        String name,
        String continent
) {

    public static DisplayCountryDto from(Country country) {
        return new DisplayCountryDto(
                country.getId(),
                country.getName(),
                country.getContinent()
        );
    }

    public static List<DisplayCountryDto> from(List<Country> countries) {
        return countries.stream().map(DisplayCountryDto::from).collect(Collectors.toList());
    }

}
