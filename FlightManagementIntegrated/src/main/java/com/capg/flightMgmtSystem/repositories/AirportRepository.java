package com.capg.flightMgmtSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.flightMgmtSystem.entities.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {

}
