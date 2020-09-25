import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../Booking';
import { FMSServiceService } from '../f-ms-service.service';
import { Passenger } from '../passenger';
import { ScheduledFlight } from '../scheduledFlight';
import { User } from '../User';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  booking: Booking = new Booking();
  passenger: Passenger;
  scheduledFlight: ScheduledFlight;
  user: User;

  submitted = false;
  constructor(private _fMSService: FMSServiceService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.user = JSON.parse(params.userDetails),
      this.scheduledFlight = JSON.parse(params.scheduledFlight),
      this.passenger = JSON.parse(params.passenger)
  });
  }

  newBooking(): void {
    this.submitted = false;
    this.booking = new Booking();
  }

  save(booking) {
    booking.user = this.user;
    booking.scheduledFlight = this.scheduledFlight;
    booking.passenger = this.passenger;
    this._fMSService.createBooking(booking)
    .subscribe(data => console.log(data),
    error => console.log(error));
    console.log(booking)
    this.booking = new Booking();
    this.gotoList();
  }

  onSubmit(booking) {
    this.submitted = true;
    this.save(booking);
  }

  gotoList() {
   
    this.router.navigate(['/signup']);
    console.log("After navigation");
  }

}
