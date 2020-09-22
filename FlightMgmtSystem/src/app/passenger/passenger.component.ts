import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FMSServiceService } from '../f-ms-service.service';
import { Passenger } from '../passenger';

@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})
export class PassengerComponent implements OnInit {

  passengerDetails:Passenger=new Passenger();
  
  constructor(private _fMSService: FMSServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }

  validatePassenger(){
    this.router.navigate(['signup']);
  }
}


