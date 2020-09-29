import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationServiceService } from '../authentication-service.service';
import { User } from '../User';

@Component({
  selector: 'app-search-booking',
  templateUrl: './search-booking.component.html',
  styleUrls: ['./search-booking.component.css']
})
export class SearchBookingComponent implements OnInit {

  accountuserName = sessionStorage.getItem('userName')
  accountUsertype = sessionStorage.getItem('userType')
  accountUserid = sessionStorage.getItem('userid')

  userName = this.accountuserName
  userType = this.accountUsertype
  userid = +this.accountUserid
      
  isUserType= false;

  user = new User();
  constructor(private router:Router, private flightService:AuthenticationServiceService) { }

  ngOnInit() {
    this.flightService.findUser(this.userid).subscribe(data => this.user = data);

    if(this.userType === "Admin" || this.userType === "admin") {
      this.isUserType = true;
    }
  }

  bookingId: number;

  viewDetails() {
    console.log(this.bookingId)
    this.router.navigate(['/viewBooking', this.bookingId]);
  }
}

