import { Flight } from './Flight';
import { Schedule } from './Schedule';

export class ScheduledFlight{
	 scheduledFlightId: number;
	 availableSeat: number;
	 schedule:Schedule;
	 flight:Flight;
	
	 ticketCost:number;
}

