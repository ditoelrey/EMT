package com.example.emtlab.dto;

public record AccommodationsByHostDTO(
        Long hostId,
        String hostName,
        Long accommodationCount
) {}