import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { BookingComponent } from './booking/booking.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { PassengerComponent } from './passenger/passenger.component';
import { RegisterComponent } from './register/register.component';
import { ScheduledFlightComponent } from './scheduled-flight/scheduled-flight.component';
import { SearchBookingComponent } from './search-booking/search-booking.component';
import { ViewAllBookingsComponent } from './view-all-bookings/view-all-bookings.component';
import { ViewBookingComponent } from './view-booking/view-booking.component';

const routes: Routes = [

  {path: '', component: HeaderComponent},
  {path: 'signup', component:RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'add-flight', component: AddFlightComponent},
  {path: 'viewAllBookings', component: ViewAllBookingsComponent},
  {path: 'viewBooking/:bookingId', component: ViewBookingComponent},
  {path: 'searchBooking', component: SearchBookingComponent},
  {path: 'createBooking', component: ScheduledFlightComponent},
  {path: 'passenger', component: PassengerComponent},
  {path: 'booking', component: BookingComponent},
  {path: 'logout', component: LogoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


