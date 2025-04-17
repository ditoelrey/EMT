package com.example.emtlab.repository;


import com.example.emtlab.model.Accommodation;
import com.example.emtlab.model.projections.CategoryProjection;
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
}
