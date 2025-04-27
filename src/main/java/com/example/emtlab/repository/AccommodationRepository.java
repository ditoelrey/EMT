package com.example.emtlab.repository;


import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.projections.CategoryProjection;
import com.example.emtlab.projections.HostAccommodationCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository <Accommodation,Long> {

    @Query("SELECT a.category, COUNT(a) " +
            "FROM Accommodation a " +
            "WHERE a.rented = true " +
            "GROUP BY a.category")
    List<Object[]> countReservedByCategory();

    @Query("""
        SELECT h.id as hostId, h.name as hostName, COUNT(a.id) as accommodationCount
        FROM Accommodation a
        JOIN a.host h
        GROUP BY h.id, h.name
        """)
    List<HostAccommodationCountProjection> countAccommodationsByHost();
    @Query(value = "REFRESH MATERIALIZED VIEW accommodations_by_host", nativeQuery = true)
    void refreshAccommodationsByHostMaterializedView();

}
