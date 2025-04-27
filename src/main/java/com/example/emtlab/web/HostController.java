package com.example.emtlab.web;

import com.example.emtlab.dto.*;
import com.example.emtlab.projections.HostNameSurnameProjection;
import com.example.emtlab.service.application.HostApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@Tag(name = "Host Controller", description = "Endpoints for managing hosts and their guests")
public class HostController {

    @Autowired
    private HostApplicationService hostApplicationService;

    @PostMapping("/{hostId}/add-guest")
    @Operation(
            summary = "Add a guest to a host",
            description = "Adds an existing guest (by ID) to the host with the specified ID. " +
                    "Updates the bidirectional relationship and returns the updated host."
    )
    public ResponseEntity<DisplayHostDto> addGuest(
            @Parameter(description = "ID of the host", required = true)
            @PathVariable Long hostId,

            @Parameter(description = "ID of the guest to add", required = true)
            @RequestParam Long guestId
    ) {
        return ResponseEntity.ok(hostApplicationService.addGuest(hostId, guestId));
    }
    @GetMapping("/by-country")
    public ResponseEntity<List<DisplayHostByCountryDTO>> getHostsByCountry() {
        List<DisplayHostByCountryDTO> result = hostApplicationService.getHostsByCountry();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    @Operation(summary = "Add new Host", description = "Creates a new host entry")
    public ResponseEntity<DisplayHostDto> save(@RequestBody CreateHostDto host) {
        return hostApplicationService.save(host)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping
    @Operation(summary = "Get all hosts", description = "Fetches all hosts from the database")
    public List<HostNameSurnameProjection> findAll() {
        return hostApplicationService.listByNameAndSurname();
    }

}
