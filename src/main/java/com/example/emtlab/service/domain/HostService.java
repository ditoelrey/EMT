package com.example.emtlab.service.domain;

import com.example.emtlab.model.Host;

import java.util.List;
import java.util.Optional;


public interface HostService {

    List<Host> findAll();

    Optional<Host> findById(Long id);

    Optional<Host> save(Host host);

    Optional<Host> update(Long id, Host manufacturer);

    void deleteById(Long id);



}
