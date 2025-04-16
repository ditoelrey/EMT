package com.example.emtlab.service.domain;

import com.example.emtlab.dto.CreateGuestDto;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {

    List<Guest> findAll();

    Optional<Guest> findById(Long id);

    Optional<Guest> save(Guest guest);

    Optional<Guest> update(Long id, Guest guest);

    void deleteById(Long id);

    Guest saveGuest(Guest guest);



}
