package com.example.emtlab.service.domain.Impl;

import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.Reservation;
import com.example.emtlab.model.User;
import com.example.emtlab.repository.ReservationRepository;
import com.example.emtlab.service.domain.AccommodationService;
import com.example.emtlab.service.domain.ReservationService;
import com.example.emtlab.service.domain.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;

    private final AccommodationService accommodationService;

    private final UserService userService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, AccommodationService accommodationService, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.accommodationService = accommodationService;
        this.userService = userService;
    }

    @Override
    public Optional<Reservation> addToTemporaryReservation(Long accommodationId, String username) {

        Accommodation accommodation = accommodationService.findById(accommodationId)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));

        if (accommodation.isRented()) return Optional.empty();

        User user = userService.findByUsername(username);

        Reservation reservation = new Reservation( user, accommodation, false);
        return Optional.of(reservationRepository.save(reservation));
    }


    @Override
    public List<Reservation> getTemporaryReservations(String username) {
        User user = userService.findByUsername(username);

        return reservationRepository.findByUserAndConfirmedFalse(user);
    }

    @Override
    @Transactional
    public void confirmReservations(String username) {
        User user = userService.findByUsername(username);
        List<Reservation> unconfirmedReservations = reservationRepository.findByUserAndConfirmedFalse(user);

        for (Reservation reservation : unconfirmedReservations) {
            reservation.setConfirmed(true);
        }

        reservationRepository.saveAll(unconfirmedReservations);
    }

    @Override
    public boolean isAccommodationReserved(Long accommodationId) {
        Optional<Accommodation> accommodationOpt = accommodationService.findById(accommodationId);

        if (accommodationOpt.isEmpty()) return false;

        return reservationRepository.existsByAccommodationAndConfirmedTrue(accommodationOpt.get());
    }
}
