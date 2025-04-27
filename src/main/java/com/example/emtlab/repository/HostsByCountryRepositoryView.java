package com.example.emtlab.repository;

import com.example.emtlab.model.views.HostsByCountryView;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HostsByCountryRepositoryView extends JpaRepository<HostsByCountryView, Long> {


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.hosts_by_country", nativeQuery = true)
    void refreshMaterializedView();
    @Query("SELECT h FROM HostsByCountryView h ORDER BY h.numHosts DESC")
    List<HostsByCountryView> findAllOrderByHostCountDesc();



}
