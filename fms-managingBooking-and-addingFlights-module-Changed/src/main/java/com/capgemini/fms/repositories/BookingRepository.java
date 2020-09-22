package com.capgemini.fms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.fms.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
}

