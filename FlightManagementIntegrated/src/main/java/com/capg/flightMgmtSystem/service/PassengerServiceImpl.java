package com.capg.flightMgmtSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capg.flightMgmtSystem.entities.Passenger;
import com.capg.flightMgmtSystem.repositories.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired 
	PassengerRepository passengerRepo;

	@Override
	public Passenger addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}


