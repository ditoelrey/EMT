package com.example.emtlab.service.domain.Impl;

import com.example.emtlab.dto.CreateGuestDto;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.Guest;
import com.example.emtlab.repository.CountryRepository;
import com.example.emtlab.repository.GuestRepository;
import com.example.emtlab.service.domain.GuestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    private final CountryRepository countryRepository;

    public GuestServiceImpl(GuestRepository guestRepository, CountryRepository countryRepository) {
        this.guestRepository = guestRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    @Override
    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }

    @Override
    public Optional<Guest> save(Guest guest) {
        return Optional.of(guestRepository.save(guest));
    }

    @Override
    public Optional<Guest> update(Long id, Guest guest) {
        return  guestRepository.findById(id).map(existingHost -> {
            if (guest.getName() != null) {
                existingHost.setName(guest.getName());
            }
            if (guest.getSurname() != null) {
                existingHost.setSurname(existingHost.getSurname());
            }
            if (guest.getCountry() != null) {
                existingHost.setCountry(guest.getCountry());
            }



            return guestRepository.save(existingHost);
        });
    }

    @Override
    public void deleteById(Long id) {

        guestRepository.deleteById(id);

    }

    @Override
    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }
}
