package com.example.emtlab.service.domain.Impl;


import com.example.emtlab.dto.AccommodationPerCategoryDTO;
import com.example.emtlab.dto.AccommodationsByHostDTO;
import com.example.emtlab.model.Accommodation;
import com.example.emtlab.projections.HostAccommodationCountProjection;
import com.example.emtlab.repository.AccommodationRepository;
import com.example.emtlab.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> save(Accommodation accommodation) {
        return Optional.of(accommodationRepository.save(accommodation));
    }


    @Override
    public Optional<Accommodation> update(Long id, Accommodation accommodation) {
        return accommodationRepository.findById(id).map(existingAccommodation -> {
            if (accommodation.getName() != null) {
                existingAccommodation.setName(accommodation.getName());
            }
            if (accommodation.getNumRooms() != null) {
                existingAccommodation.setNumRooms(accommodation.getNumRooms());
            }
            if (accommodation.getHost() != null) {
                existingAccommodation.setHost(accommodation.getHost());
            }

            if (accommodation.getCategory() != null) {
                existingAccommodation.setCategory(accommodation.getCategory());
            }

            return accommodationRepository.save(existingAccommodation);
        });
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

    @Override
    public List<AccommodationPerCategoryDTO> statistics() {
        return this.accommodationRepository.countReservedByCategory().stream().map((obj)->new AccommodationPerCategoryDTO(String.valueOf(obj[0]),((Number) obj[1]).intValue())).collect(Collectors.toList());
    }

    @Override
    public void rentAccommodation(Long id) {
        Accommodation tmp=this.accommodationRepository.findById(id).get();
        tmp.setRented(true);
        this.accommodationRepository.save(tmp);
    }

    @Override
    public void refreshAccommodationsByHostMaterializedView() {
        accommodationRepository.refreshAccommodationsByHostMaterializedView();
    }

    @Override
    public List<AccommodationsByHostDTO> getAccommodationsCountByHost() {
        return accommodationRepository.countAccommodationsByHost().stream()
                .map(projection -> new AccommodationsByHostDTO(
                        projection.getHostId(),
                        projection.getHostName(),
                        projection.getAccommodationCount()
                ))
                .collect(Collectors.toList());
    }
}
