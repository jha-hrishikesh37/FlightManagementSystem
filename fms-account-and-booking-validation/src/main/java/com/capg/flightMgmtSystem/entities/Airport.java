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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="schedule_id")
	private Schedule schedule;
}
