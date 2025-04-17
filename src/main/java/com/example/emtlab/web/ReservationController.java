package com.example.emtlab.web;


import com.example.emtlab.dto.DisplayReservationDto;
import com.example.emtlab.service.application.ReservationApplicationService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

     private final ReservationApplicationService reservationApplicationService;

    public ReservationController(ReservationApplicationService reservationApplicationService) {
        this.reservationApplicationService = reservationApplicationService;
    }

    @GetMapping("/temporary")
    @Operation(
            summary = "Get all temporary reservations for a user",
            description = "Returns a list of all temporary reservations for the specified user.")
    public ResponseEntity<List<DisplayReservationDto>> getTemporaryReservations(
            @Parameter(description = "Username of the user", required = true)
            @RequestParam String username
    ) {
        List<DisplayReservationDto> reservations = reservationApplicationService.getTemporaryReservations(username);
        return ResponseEntity.ok(reservations);
    }

    @PostMapping("/add")
    @Operation(
            summary = "Add an accommodation to a user's temporary reservation list",
            description = "Adds an accommodation to the temporary reservation list for the user. " +
                    "If the accommodation is already reserved, a message will be returned."
    )
    public ResponseEntity<DisplayReservationDto> addToTemporaryReservation(
            @Parameter(description = "ID of the accommodation", required = true)
            @RequestParam Long accommodationId,

            @Parameter(description = "Username of the user", required = true)
            @RequestParam String username
    ) {
        Optional<DisplayReservationDto> reservation = reservationApplicationService.addToTemporaryReservation(accommodationId, username);

        return reservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @PostMapping("/confirm")
    @Operation(
            summary = "Confirm all temporary reservations for a user",
            description = "Confirms all temporary reservations for the specified user and marks accommodations as reserved."
    )
    public ResponseEntity<Void> confirmReservations(
            @Parameter(description = "Username of the user", required = true)
            @RequestParam String username
    ) {
        reservationApplicationService.confirmReservations(username);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/check")
    @Operation(
            summary = "Check if an accommodation is reserved",
            description = "Returns true if the accommodation is already reserved, otherwise false."
    )
    public ResponseEntity<Boolean> isAccommodationReserved(
            @Parameter(description = "ID of the accommodation", required = true)
            @RequestParam Long accommodationId
    ) {
        boolean isReserved = reservationApplicationService.isAccommodationReserved(accommodationId);
        return ResponseEntity.ok(isReserved);
    }

}
