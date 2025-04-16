package com.example.emtlab.dto;

import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.Host;

import java.util.List;
import java.util.stream.Collectors;

public record CreateCountryDto (

         String name,
         String continent

) {
    public static CreateCountryDto from(Country country) {
        return new CreateCountryDto(
                country.getName(),
                country.getContinent()
        );
    }

    public static List<CreateCountryDto> from(List<Country> countries) {

        return countries.stream().map(CreateCountryDto::from).collect(Collectors.toList());

    }

    public Country toCountry () {
        return new Country(name,continent);
    }
}
