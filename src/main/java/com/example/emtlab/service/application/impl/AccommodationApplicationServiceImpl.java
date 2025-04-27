package com.example.emtlab.service.application.impl;

import com.example.emtlab.dto.AccommodationPerCategoryDTO;
import com.example.emtlab.dto.AccommodationsByHostDTO;
import com.example.emtlab.dto.CreateAccommodationDto;
import com.example.emtlab.dto.DisplayAccommodationDto;
import com.example.emtlab.model.Host;
import com.example.emtlab.repository.AccommodationRepository;
import com.example.emtlab.service.application.AccommodationApplicationService;
import com.example.emtlab.service.domain.AccommodationService;
import com.example.emtlab.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    private final AccommodationService accommodationService;
    private final HostService hostService;


    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return accommodationService.findAll().stream().map(DisplayAccommodationDto::from).collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService.findById(id).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        Optional<Host> host = hostService.findById(createAccommodationDto.hostId());

        return accommodationService.update(id, createAccommodationDto.toAccomodation(host.orElse(null))).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> save(CreateAccommodationDto createAccommodationDto) {

        Optional<Host> host = hostService.findById(createAccommodationDto.hostId());

        if (host.isPresent()) {

            return accommodationService.save(createAccommodationDto.toAccomodation(host.get())).map(DisplayAccommodationDto::from);
        }

        return Optional.empty();
    }


    @Override
    public void deleteById(Long id) {
        accommodationService.deleteById(id);

    }

    @Override
    public List<AccommodationPerCategoryDTO> statistics() {
        return this.accommodationService.statistics();
    }

    @Override
    public void rentAccommodation(Long id) {
        this.accommodationService.rentAccommodation(id);
    }

    @Override
    public void refreshAccommodationsByHostMaterializedView() {
        accommodationService.refreshAccommodationsByHostMaterializedView();
    }

    @Override
    public List<AccommodationsByHostDTO> getAccommodationsCountByHost() {
        return accommodationService.getAccommodationsCountByHost();
    }

}
