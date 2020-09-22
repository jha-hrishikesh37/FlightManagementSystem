package com.capgemini.fms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.fms.entities.Airport;


@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {

}
