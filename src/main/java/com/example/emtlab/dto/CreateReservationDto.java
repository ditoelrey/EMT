package com.example.emtlab.dto;

import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.Host;
import com.example.emtlab.model.Reservation;
import com.example.emtlab.model.User;

import java.util.List;
import java.util.stream.Collectors;

public record CreateReservationDto(Long accommodationId, String username) {

    public static CreateReservationDto from(Reservation reservation) {
        return new CreateReservationDto(
                reservation.getAccommodation().getId(),
                reservation.getUser().getUsername()
        );
    }

    public static List<CreateReservationDto> from(List<Reservation> reservations) {

        return reservations.stream().map(CreateReservationDto::from).collect(Collectors.toList());

    }

    public Reservation toReservation (Accommodation accommodation, User user) {
        return new Reservation(user,accommodation,false);
    }
}


