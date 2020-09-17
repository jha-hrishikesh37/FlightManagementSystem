package com.capgemini.fms.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.fms.entities.Booking;


@Repository
public interface BookingDao extends CrudRepository<Booking, BigInteger> {

}
