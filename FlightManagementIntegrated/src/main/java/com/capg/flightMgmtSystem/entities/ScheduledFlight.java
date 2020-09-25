package com.capg.flightMgmtSystem.entities;
import javax.persistence.CascadeType;
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
@Table(name = "sheduled_flight")
public class ScheduledFlight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scheduled_flight_id")
	private Long scheduledFlightId;
	@Column(name = "available_seat")
	private int availableSeat;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "flight_id")
	private Flight flight;
	
	@Override
	public String toString() {
		return "scheduledFlightId=" + scheduledFlightId + ", availableSeat=" + availableSeat
				+ ", \n" + schedule + ", \n" + flight+"\n";
	}
	
	public ScheduledFlight(Long scheduledFlightId, int availableSeat, Schedule schedule, Flight flight) {
		super();
		this.scheduledFlightId = scheduledFlightId;
		this.availableSeat = availableSeat;
		this.schedule = schedule;
		this.flight = flight;
	}
}


