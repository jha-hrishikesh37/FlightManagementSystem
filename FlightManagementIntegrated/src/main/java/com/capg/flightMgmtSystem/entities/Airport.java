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
@Table(name = "airport")
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "airport_code")
	private String airportCode;
	@Column(name = "airport_name")
	private String airportName;
	@Column(name = "airport_location")
	private String airportLocation;
		
	@Override
	public String toString() {
		return "airportCode=" + airportCode + ", airportName=" + airportName + ", airportLocation="
				+ airportLocation ;
	}

	public Airport(String airportCode, String airportName, String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}

}


