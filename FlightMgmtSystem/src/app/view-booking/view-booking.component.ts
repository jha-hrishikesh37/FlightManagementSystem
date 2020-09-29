import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationServiceService } from '../authentication-service.service';
import { Booking } from '../Booking';
import { User } from '../User';

@Component({
  selector: 'app-view-booking',
  templateUrl: './view-booking.component.html',
  styleUrls: ['./view-booking.component.css']
})
export class ViewBookingComponent implements OnInit {


  accountuserName = sessionStorage.getItem('userName')
  accountUsertype = sessionStorage.getItem('userType')
  accountUserid = sessionStorage.getItem('userid')

  userName = this.accountuserName
  userType = this.accountUsertype
  userid = +this.accountUserid
      
  isUserType= false;

  user = new User();
  
  bookingId: number;
  booking: Booking;

  constructor(private route:ActivatedRoute, private router:Router, private flightService:AuthenticationServiceService) { }

  ngOnInit() {
    this.flightService.findUser(this.userid).subscribe(data => this.user = data);

    if(this.userType === "Admin" || this.userType === "admin") {
      this.isUserType = true;
    }
    this.booking = new Booking();

    this.bookingId = this.route.snapshot.params['bookingId'];

    this.flightService.getBooking(this.bookingId).subscribe (
      data => {
        console.log(data);
        this.booking = data;
      },
      error => console.log(error)
    );
  }

  updateBooking(bookingId: number) {
    this.router.navigate(['manage-booking', bookingId])
    .then(() => {
      window.location.reload();
    });
  }

  deleteBooking(bookingId: number) {
    this.flightService.deleteBooking(bookingId).subscribe(
      data=> {
        console.log(data);
      },
      error => console.log(error)
    );
  }
}


