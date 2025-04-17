package com.example.emtlab.service.domain;

import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.Reservation;
import com.example.emtlab.model.User;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Optional <Reservation> addToTemporaryReservation(Long accommodationId, String username);

    List<Reservation> getTemporaryReservations(String username);

    void confirmReservations(String username);

    boolean isAccommodationReserved(Long accommodationId);

}
