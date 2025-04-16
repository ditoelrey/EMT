package com.example.emtlab.web;

import com.example.emtlab.dto.CreateGuestDto;
import com.example.emtlab.dto.DisplayGuestDto;
import com.example.emtlab.service.application.GuestApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@Tag(name = "Guest Controller", description = "Endpoints for managing guests")
public class GuestController {

    private final GuestApplicationService guestApplicationService;

    public GuestController(GuestApplicationService guestApplicationService) {
        this.guestApplicationService = guestApplicationService;
    }

    @PostMapping
    @Operation(
            summary = "Create a new guest",
            description = "Creates a new guest using the provided data and returns the saved guest as a DTO"
    )
    public ResponseEntity<DisplayGuestDto> createGuest(
            @RequestBody CreateGuestDto guestDto
    ) {
        return ResponseEntity.ok(guestApplicationService.saveGuest(guestDto));
    }

    @GetMapping
    @Operation(
            summary = "Get all guests",
            description = "Returns a list of all guests in the system"
    )
    public ResponseEntity<List<DisplayGuestDto>> getGuests() {
        return ResponseEntity.ok(guestApplicationService.findAll());
    }
}
