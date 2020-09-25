package com.capg.flightMgmtSystem.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.flightMgmtSystem.entities.Passenger;
public interface PassengerService{

	Passenger addPassenger(Passenger passenger);
}


