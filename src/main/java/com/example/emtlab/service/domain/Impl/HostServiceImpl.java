package com.example.emtlab.service.domain.Impl;

import com.example.emtlab.model.Guest;
import com.example.emtlab.model.Host;
import com.example.emtlab.repository.GuestRepository;
import com.example.emtlab.repository.HostRepository;
import com.example.emtlab.service.domain.GuestService;
import com.example.emtlab.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    private final GuestRepository guestRepository;

    public HostServiceImpl(HostRepository hostRepository, GuestRepository guestRepository) {
        this.hostRepository = hostRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Optional<Host> save(Host host) {
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return hostRepository.findById(id).map(existingHost -> {
            if (host.getName() != null) {
                existingHost.setName(host.getName());
            }
            if (host.getSurname() != null) {
                existingHost.setSurname(existingHost.getSurname());
            }
            if (host.getCountry() != null) {
                existingHost.setCountry(host.getCountry());
            }

            return hostRepository.save(existingHost);
        });
    }

    @Override
    public void deleteById(Long id) {
      hostRepository.deleteById(id);
    }

    @Override
    public Host addGuest(Long hostId, Long guestId) {
      Host host =  hostRepository.findById(hostId).orElse(null);
       Guest guest =  guestRepository.findById(guestId).orElse(null);
       host.getGuests().add(guest);
       guest.getHosts().add(host);
        guestRepository.save(guest);
        return hostRepository.save(host);

    }
}
