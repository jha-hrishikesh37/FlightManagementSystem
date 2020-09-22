import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FMSServiceService } from '../f-ms-service.service';

@Component({
  selector: 'app-flight-booking',
  templateUrl: './flight-booking.component.html',
  styleUrls: ['./flight-booking.component.css']
})
export class FlightBookingComponent implements OnInit {

  submitted=false;
  constructor(private _fMSService: FMSServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }

  validateUser(){
    console.log("Happy");
    this.submitted=true;
    this.router.navigate(['passenger']);
  }
}