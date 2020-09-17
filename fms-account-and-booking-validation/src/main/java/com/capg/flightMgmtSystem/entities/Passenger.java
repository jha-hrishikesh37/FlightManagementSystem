package com.capg.flightMgmtSystem.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter

@Entity
@Table(name = "passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "passenger_id")
	private Long passengerId; 
	@Column(name = "passenger_name")
	private String passengerName;
	@Column(name = "passenger_age")
	private int passengerAge;
	@Column(name = "passenger_uid")
	private Long passengerUniqueId;
	@Column(name = "luggage")
	private double luggage; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id")
	private Booking booking;
}
