package com.example.emtlab.service.application.impl;


import com.example.emtlab.dto.DisplayReservationDto;
import com.example.emtlab.model.Reservation;
import com.example.emtlab.service.application.ReservationApplicationService;
import com.example.emtlab.service.domain.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationApplicationServiceImpl implements ReservationApplicationService {

    private final ReservationService reservationService;

    public ReservationApplicationServiceImpl(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public Optional<DisplayReservationDto> addToTemporaryReservation(Long accommodationId, String username) {
        Optional<Reservation> reservationOptional = reservationService.addToTemporaryReservation(accommodationId, username);

        return reservationOptional.map(DisplayReservationDto::from);
    }

    @Override
    public List<DisplayReservationDto> getTemporaryReservations(String username) {
        List<Reservation> reservations = reservationService.getTemporaryReservations(username);

        return reservations.stream()
                .map(DisplayReservationDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public void confirmReservations(String username) {
        reservationService.confirmReservations(username);
    }

    @Override
    public boolean isAccommodationReserved(Long accommodationId) {
        return reservationService.isAccommodationReserved(accommodationId);
    }
}
