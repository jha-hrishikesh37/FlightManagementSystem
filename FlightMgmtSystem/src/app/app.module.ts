import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { ViewBookingComponent } from './view-booking/view-booking.component';
import { SearchBookingComponent } from './search-booking/search-booking.component';
import { PassengerComponent } from './passenger/passenger.component';
import { ScheduledFlightComponent } from './scheduled-flight/scheduled-flight.component';
import { BookingComponent } from './booking/booking.component';
import { FooterComponent } from './footer/footer.component';
import { ViewAllBookingsComponent } from './view-all-bookings/view-all-bookings.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    AddFlightComponent,
    ViewBookingComponent,
    SearchBookingComponent,
    PassengerComponent,
    ScheduledFlightComponent,
    BookingComponent,
    FooterComponent,
    ViewAllBookingsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


