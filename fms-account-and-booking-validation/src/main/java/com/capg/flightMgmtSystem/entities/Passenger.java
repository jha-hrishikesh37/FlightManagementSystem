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
	
	@Override
	public String toString() {
		return "passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerUniqueId=" + passengerUniqueId + ", luggage=" + luggage;
	}
	
	public Passenger(Long passengerId, String passengerName, int passengerAge, Long passengerUniqueId, double luggage) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUniqueId = passengerUniqueId;
		this.luggage = luggage;
	}
}
