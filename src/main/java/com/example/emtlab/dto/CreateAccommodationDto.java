package com.example.emtlab.dto;

import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.Host;
import com.example.emtlab.model.enumerations.Category;

import java.util.List;
import java.util.stream.Collectors;

public record CreateAccommodationDto(
        String name,
        Integer numRooms,

        Long hostId,
        Category category,
        boolean rented
) {

    public static CreateAccommodationDto from(Accommodation accommodation) {
        return new CreateAccommodationDto(
                accommodation.getName(),
                accommodation.getNumRooms(),
                accommodation.getHost().getId(),
                accommodation.getCategory(),
                accommodation.isRented()
        );
    }

    public static List<CreateAccommodationDto> from(List<Accommodation> accommodations) {

        return accommodations.stream().map(CreateAccommodationDto::from).collect(Collectors.toList());

    }

    public Accommodation toAccomodation (Host host) {
        return new Accommodation(name, host,numRooms,category,rented);
    }



}


