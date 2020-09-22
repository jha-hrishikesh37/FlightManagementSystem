package com.capgemini.fms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.fms.entities.ScheduledFlight;

@Repository
public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long> {

}
