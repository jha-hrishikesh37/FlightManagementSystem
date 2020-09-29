import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationServiceService } from '../authentication-service.service';
import { Booking } from '../Booking';
import { Passenger } from '../passenger';
import { ScheduledFlight } from '../scheduledFlight';
import { User } from '../User';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  accountUsername = sessionStorage.getItem('username')
  accountUsertype = sessionStorage.getItem('userType')
  accountUserid = sessionStorage.getItem('userid')

  scheduleFlightId = localStorage.getItem('schedule')

  sid = +this.scheduleFlightId;
 
  username = this.accountUsername
  userType = this.accountUsertype
  userid = +this.accountUserid

  isUserType= false;

  user = new User();
  booking: Booking = new Booking();
  passenger: Passenger;
  scheduledFlight: ScheduledFlight;
  

  submitted = false;
  constructor(private _fMSService: AuthenticationServiceService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this._fMSService.findUser(this.userid).subscribe(data => this.user = data);

    this._fMSService.showFlightWithId(this.sid).subscribe(data =>this.scheduledFlight=data)

    
    if(this.userType === "Admin" || this.userType === "admin") {
      this.isUserType = true;
    }

    this.route.queryParams.subscribe(params => {
      this.passenger = JSON.parse(params.passenger)
  });
  }

  newBooking(): void {
    this.submitted = false;
    this.booking = new Booking();
  }

  save() {
    console.log(this.user);
    this.booking.user = this.user;
    this.booking.scheduledFlight = this.scheduledFlight;
    this.booking.passenger = this.passenger;
    this._fMSService.createBooking(this.booking)
    .subscribe(data => console.log(data),
    error => console.log(error));
    this.gotoList();
  }

  onSubmit() {
    
    this.submitted = true;
    this.save();
  }

  gotoList() {
    console.log(this.booking);
    this.router.navigate(['/signup']);
    console.log("After navigation");
  }

}

