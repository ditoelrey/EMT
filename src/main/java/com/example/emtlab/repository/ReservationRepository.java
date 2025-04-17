package com.example.emtlab.repository;

import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.Reservation;
import com.example.emtlab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository  extends JpaRepository<Reservation,Long> {

    List<Reservation> findByUser(User user);

    List<Reservation> findByUserAndConfirmedFalse(User user);

    boolean existsByAccommodationAndConfirmedTrue(Accommodation accommodation);



}
