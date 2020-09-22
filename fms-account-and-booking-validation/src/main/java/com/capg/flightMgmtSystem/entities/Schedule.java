package com.capg.flightMgmtSystem.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne
	@JoinColumn(name="source")
	private Airport sourceAirport;
	
	@OneToOne
	@JoinColumn(name="destination")
	private Airport destinationAirport;
	
	@Override
	public String toString() {
		return "scheduleId= " + scheduleId + ", arrivalTime= " + arrivalTime + ", departureTime= "
				+ departureTime + ", \nSource Airport= "+sourceAirport +"\n Destination Airport= "+ destinationAirport+"\n";
	}

	public Schedule(Long scheduleId, Date date1, Date date12, Airport sourceAirport,
			Airport destinationAirport) {
		super();
		this.scheduleId = scheduleId;
		this.arrivalTime = date1;
		this.departureTime = date12;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
	}
}


