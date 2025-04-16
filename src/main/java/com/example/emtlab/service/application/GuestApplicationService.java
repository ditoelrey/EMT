package com.example.emtlab.service.application;

import com.example.emtlab.dto.CreateAccommodationDto;
import com.example.emtlab.dto.CreateGuestDto;
import com.example.emtlab.dto.DisplayAccommodationDto;
import com.example.emtlab.dto.DisplayGuestDto;
import com.example.emtlab.model.Guest;

import java.util.List;
import java.util.Optional;


public interface GuestApplicationService {

    List<DisplayGuestDto> findAll();

    Optional<DisplayGuestDto> save(CreateGuestDto createGuestDto);

    Optional<DisplayGuestDto> findById(Long id);

    Optional<DisplayGuestDto> update(Long id, CreateGuestDto createGuestDto);

    DisplayGuestDto saveGuest(CreateGuestDto createGuestDto);

    void deleteById(Long id);
}
