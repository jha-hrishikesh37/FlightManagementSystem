import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookingComponent } from './booking/booking.component';
import { FlightBookingComponent } from './flight-booking/flight-booking.component';
import { PassengerComponent } from './passenger/passenger.component';
import { RegisterComponent } from './register/register.component';
import { ScheduledFlightComponent } from './scheduled-flight/scheduled-flight.component';

const routes: Routes = [
  { path: '', redirectTo: 'signup', pathMatch: 'full' },
  { path: 'signup', component: RegisterComponent },
  { path: 'booking', component: FlightBookingComponent},
  { path: 'passenger', component: PassengerComponent},
  { path: 'allFlights', component: ScheduledFlightComponent},
  { path: 'finalBooking', component: BookingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

  
}

