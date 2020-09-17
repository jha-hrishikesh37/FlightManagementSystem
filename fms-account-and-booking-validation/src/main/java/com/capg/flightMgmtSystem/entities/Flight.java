package com.capg.flightMgmtSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "flight_number")
	private Long flightNumber;
	@Column(name = "carrier_name")
	private String carrierName;
	@Column(name = "flight_model")
	private String flightModel;
	@Column(name = "seat_capacity")
	private int seatCapacity;
	
}
