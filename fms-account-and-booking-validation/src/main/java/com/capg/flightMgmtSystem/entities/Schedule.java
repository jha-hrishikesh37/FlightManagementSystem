package com.capg.flightMgmtSystem.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "shedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "schedule_id")
	private Long scheduleId;
	@Column(name = "arrival_time")
	private Date arrivalTime;
	@Column(name = "departure_time")
	private Date departureTime;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule")
	private List<Airport> Airport;
}
