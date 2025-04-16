package com.example.emtlab.repository;

import com.example.emtlab.model.Country;
import com.example.emtlab.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {
}
