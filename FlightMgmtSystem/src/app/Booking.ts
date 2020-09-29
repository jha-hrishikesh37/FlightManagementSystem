import { Passenger } from './Passenger';
import { ScheduledFlight } from './ScheduledFlight';
import { User } from './User';

export class Booking{
     bookingId:number;
	 user:User;
	 passenger:Passenger;
	 scheduledFlight:ScheduledFlight;

}
