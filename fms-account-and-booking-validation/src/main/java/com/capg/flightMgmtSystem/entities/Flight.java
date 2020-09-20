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

@NoArgsConstructor
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
	
	@Override
	public String toString() {
		return "flightNumber= " + flightNumber + ", carrierName= " + carrierName + ", flightModel= " + flightModel
				+ ", seatCapacity= " + seatCapacity+"\n";
	}
	
	public Flight(Long flightNumber, String carrierName, String flightModel, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}
}
