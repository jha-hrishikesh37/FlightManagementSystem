package com.capg.flightMgmtSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.flightMgmtSystem.entities.ScheduledFlight;

@Repository
public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long> {

}
