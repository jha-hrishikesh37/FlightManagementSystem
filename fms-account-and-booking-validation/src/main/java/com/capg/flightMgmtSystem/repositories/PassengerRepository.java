package com.capg.flightMgmtSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.flightMgmtSystem.entities.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}

