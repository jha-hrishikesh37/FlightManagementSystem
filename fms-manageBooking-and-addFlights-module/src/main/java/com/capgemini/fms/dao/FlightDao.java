package com.capgemini.fms.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.fms.entities.Flight;

@Repository
public interface FlightDao extends CrudRepository<Flight, BigInteger>{

}
