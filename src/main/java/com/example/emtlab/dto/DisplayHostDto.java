package com.example.emtlab.dto;

import com.example.emtlab.model.Guest;
import com.example.emtlab.model.Host;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayHostDto(Long id,
                             String name,
                             String surname,
                             Long countryId,
                             List<Long> guestIds
) {
    public static DisplayHostDto from(Host host) {
        return new DisplayHostDto(
                host.getId(),
                host.getName(),
                host.getSurname(),
                host.getCountry().getId(),
                host.getGuests().stream().map(Guest::getId).collect(Collectors.toList())
        );
    }

    public static List<DisplayHostDto> from(List<Host> hosts) {
        return hosts.stream().map(DisplayHostDto::from).collect(Collectors.toList());
    }
}

