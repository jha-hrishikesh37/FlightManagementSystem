import { Passenger } from './Passenger';
import { ScheduledFlight } from './ScheduledFlight';
import { User } from './User';

export class BookingDetails{
	 bookingDate:Date;
	 ticketCost:number;
	 numberOfPassengers:number;
	 user:User;
	 passenger:Passenger;
	 scheduledFlight:ScheduledFlight;

}

