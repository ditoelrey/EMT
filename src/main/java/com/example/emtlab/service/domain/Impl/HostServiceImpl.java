package com.example.emtlab.service.domain.Impl;

import com.example.emtlab.model.Host;
import com.example.emtlab.repository.HostRepository;
import com.example.emtlab.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
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
}
