package com.example.emtlab.dto;

import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.Host;
import com.example.emtlab.model.enumerations.Category;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAccommodationDto(
        Long id,
        String name,
        Integer numRooms,

        Long host,
        Category category,
        boolean rented
) {

    public static DisplayAccommodationDto from(Accommodation accommodation) {
        return new DisplayAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getNumRooms(),
                accommodation.getHost().getId() != null ? accommodation.getHost().getId() : null,
                accommodation.getCategory(),
                accommodation.isRented()

        );
    }

    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations) {

        return accommodations.stream().map(DisplayAccommodationDto::from).collect(Collectors.toList());

    }

    public Accommodation toAccommodation (Host host) {
        return new Accommodation(name,host,numRooms,category,rented);

    }
}
