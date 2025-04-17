package com.example.emtlab.dto;

import com.example.emtlab.model.Reservation;

public record DisplayReservationDto(Long reservationId, String accommodationName, String userName, boolean confirmed) {

    public static DisplayReservationDto from(Reservation reservation) {
        return new DisplayReservationDto(
                reservation.getId(),
                reservation.getAccommodation().getName(),
                reservation.getUser().getUsername(),
                reservation.isConfirmed()
        );
    }
}
