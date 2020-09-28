package com.capg.flightMgmtSystem.entities;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private Long bookingId;
	@Column(name = "booking_date")
	private Date bookingDate;
	@Column(name = "ticket_cost")
	private double ticketCost;
//	@Column(name = "no_passegeners")
//	private int numberOfPassengers;
//	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="passenger_id")
	private Passenger passenger;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="scheduled_flight_id")
	private ScheduledFlight scheduledFlight;
	
	@Override
	public String toString() {
		return "bookingId=" + bookingId + ", bookingDate=" + bookingDate +", ticketCost= "+ticketCost
				+  ",\n" + user + ",\n" + passenger
				+ ",\n" + scheduledFlight+"\n";
	}

	public Booking(Long bookingId, Date bookingDate, double ticketCost, User user,
			Passenger passenger, ScheduledFlight scheduledFlight) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.user = user;
		this.passenger = passenger;
		this.scheduledFlight = scheduledFlight;
	}

}
