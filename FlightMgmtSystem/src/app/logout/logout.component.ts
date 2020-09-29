import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from '../authentication-service.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authenticationService:AuthenticationServiceService, private router:Router) { }

  ngOnInit(): void {
    this.authenticationService.logOut();
    this.router.navigate(['login']);
  }

}

