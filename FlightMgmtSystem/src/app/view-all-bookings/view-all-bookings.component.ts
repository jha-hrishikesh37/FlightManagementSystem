import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationServiceService } from '../authentication-service.service';
import { Booking } from '../Booking';
import { ScheduledFlight } from '../ScheduledFlight';
import { User } from '../User';

@Component({
  selector: 'app-view-all-bookings',
  templateUrl: './view-all-bookings.component.html',
  styleUrls: ['./view-all-bookings.component.css']
})
export class ViewAllBookingsComponent implements OnInit {

  accountuserName = sessionStorage.getItem('userName')
  accountUsertype = sessionStorage.getItem('userType')
  accountUserid = sessionStorage.getItem('userid')

  userName = this.accountuserName
  userType = this.accountUsertype
  userid = +this.accountUserid
      message=""
  isUserType= false;

  allBookings: Observable<Booking[]>;
  bookingId=0;
  user:User;
  bookUser:Booking;

  constructor(private _fMSService: AuthenticationServiceService,
    private router: Router,
    private route: ActivatedRoute) {}

    submitted=false;
  error=null;
  subId=true;

  ngOnInit(): void {
    console.log("Hello")
    this._fMSService.getAllBookings().subscribe(
      (data:Observable<Booking[]>)=>this.allBookings=data);      
  }

  add(schedeuledFlights){
    localStorage.setItem('schedule',schedeuledFlights+"")
    console.log(localStorage.getItem('schedule'));
    this.router.navigate(['/passenger'])
    
   console.log("OKs"+schedeuledFlights);
  }

  searchById(){
    this.subId=false;
  }
  
  showBookingById() {
    this.submitted=true;
    this._fMSService.getBooking(this.bookingId)
    .subscribe((data) => {
      console.log(data)
      this.bookUser=data;
      this.submitted=true;
      console.log(this.bookUser);
    }, error =>{ this.error=error;
      this.submitted=false
      console.log(error.error);
      this.error=error.error.message;
      alert(error.error)
      this.submitted=false;
     });
  }

  back() {
    this.submitted=false;
    this.subId=true;
  }
}


