package com.example.emtlab.dto;

import com.example.emtlab.model.Guest;
import com.example.emtlab.model.Host;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayGuestDto(
        Long id,
        String name,
        String surname,
        Long countryId,
        List<Long> hostIds
) {
    public static DisplayGuestDto from(Guest guest) {
        return new DisplayGuestDto(
                guest.getId(),
                guest.getName(),
                guest.getSurname(),
                guest.getCountry().getId(),
                guest.getHosts().stream().map(Host::getId).collect(Collectors.toList())
        );
    }

    public static List<DisplayGuestDto> from(List<Guest> guests) {
        return guests.stream().map(DisplayGuestDto::from).collect(Collectors.toList());
    }
}
