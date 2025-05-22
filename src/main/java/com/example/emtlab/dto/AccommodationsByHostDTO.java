package com.example.emtlab.dto;

import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.Country;

public record AccommodationsByHostDTO(
        Long hostId,
        String hostName,
        Long accommodationCount
) { }