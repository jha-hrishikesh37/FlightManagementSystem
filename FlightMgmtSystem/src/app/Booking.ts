import { Passenger } from './passenger';
import { ScheduledFlight } from './scheduledFlight';
import { User } from './User';

export class Booking {

    bookingId: number;
    bookingDate: string;
    noOfPassengers: number;
    ticketCost:number;
    passenger: Passenger;
    scheduledFlight: ScheduledFlight;
    user: User;
  
  }
  

  