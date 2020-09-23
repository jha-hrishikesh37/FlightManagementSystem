import { Passenger } from './passenger';
import { ScheduledFlight } from './scheduledFlight';
import { User } from './User';

export class Booking {

    bookingId: number;
    bookingDate: string;
    noOfPassengers: number;
    passenger: Passenger;
    scheduleFlight: ScheduledFlight;
    user: User;
  
  }
  