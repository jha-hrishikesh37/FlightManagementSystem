import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../User';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  accountUsername = sessionStorage.getItem('username')
  accountUsertype = sessionStorage.getItem('userType')
  accountUserid = sessionStorage.getItem('userid')

  username = this.accountUsername
  userType = this.accountUsertype
  userid = +this.accountUserid

  isUserType= false;

  user = new User();

  constructor(
    private router: Router,
    // private loginService: AuthenticationService,
    // private flightService: FlightManagementService
    ) { }


  ngOnInit() {
    // this.flightService.findUser(this.userid).subscribe(data => this.user = data);

    // if(this.userType === "Admin" || this.userType === "admin") {
    //   this.isUserType = true;
    // }
  }


}
