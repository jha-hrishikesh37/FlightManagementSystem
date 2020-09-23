import { Schedule } from './schedule';
import { Flight } from './flight';

export class ScheduledFlight {
    scheduledFlightId: number;
    flight: Flight;
    availableSeat: number;
    schedule: Schedule;
}