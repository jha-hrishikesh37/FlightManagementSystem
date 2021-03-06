package com.capg.flightMgmtSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.flightMgmtSystem.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
}

