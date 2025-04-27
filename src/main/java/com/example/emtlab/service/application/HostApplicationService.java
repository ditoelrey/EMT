package com.example.emtlab.service.application;

import com.example.emtlab.dto.CreateHostDto;
import com.example.emtlab.dto.DisplayHostByCountryDTO;
import com.example.emtlab.dto.DisplayHostDto;
import com.example.emtlab.model.Host;
import com.example.emtlab.projections.HostNameSurnameProjection;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {

    List<DisplayHostDto> findAll();

    Optional<DisplayHostDto> findById(Long id);

    Optional<DisplayHostDto> save(CreateHostDto createHostDto);

    Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto);

    void deleteById(Long id);

    DisplayHostDto addGuest (Long hostId, Long guestId);

    List<DisplayHostByCountryDTO> getHostsByCountry();

    public List<HostNameSurnameProjection> listByNameAndSurname();
}
