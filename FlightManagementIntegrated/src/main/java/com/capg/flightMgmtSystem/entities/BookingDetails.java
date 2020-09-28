package com.capg.flightMgmtSystem.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class BookingDetails {
	private double ticketCost;
	private int numberOfPassengers;
	private User user;
	private Passenger passenger;
	private ScheduledFlight scheduledFlight;
	
	

}

