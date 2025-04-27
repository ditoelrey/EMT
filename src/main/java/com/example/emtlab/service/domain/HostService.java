package com.example.emtlab.service.domain;

import com.example.emtlab.dto.DisplayHostByCountryDTO;
import com.example.emtlab.dto.DisplayHostDto;
import com.example.emtlab.model.Host;
import com.example.emtlab.projections.HostNameSurnameProjection;

import java.util.List;
import java.util.Optional;


public interface HostService {

    List<Host> findAll();

    Optional<Host> findById(Long id);

    Optional<Host> save(Host host);

    Optional<Host> update(Long id, Host host);

    void deleteById(Long id);

    Host addGuest (Long hostId, Long guestId);

    public void refreshMaterializedView();

    List<DisplayHostByCountryDTO> getHostsByCountry();

    List<HostNameSurnameProjection> listByNameAndSurname();




}
