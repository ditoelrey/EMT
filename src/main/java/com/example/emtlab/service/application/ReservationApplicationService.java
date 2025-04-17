package com.example.emtlab.service.application;

import com.example.emtlab.dto.DisplayReservationDto;
import com.example.emtlab.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationApplicationService {

    Optional<DisplayReservationDto> addToTemporaryReservation(Long accommodationId, String username);

    List<DisplayReservationDto> getTemporaryReservations(String username);

    void confirmReservations(String username);

    boolean isAccommodationReserved(Long accommodationId);
}
