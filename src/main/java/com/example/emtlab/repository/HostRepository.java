package com.example.emtlab.repository;


import com.example.emtlab.model.Host;
import com.example.emtlab.projections.HostNameSurnameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends JpaRepository <Host,Long> {

    List<HostNameSurnameProjection> findAllBy();

}
