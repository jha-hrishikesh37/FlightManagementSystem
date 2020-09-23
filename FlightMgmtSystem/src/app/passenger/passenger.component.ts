import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationExtras, Router } from '@angular/router';
import { FMSServiceService } from '../f-ms-service.service';
import { Passenger } from '../passenger';
import { ScheduledFlight } from '../scheduledFlight';
import { User } from '../User';

@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})
export class PassengerComponent implements OnInit {

  passengerDetails:Passenger=new Passenger();
  scheduledFlight: ScheduledFlight=new ScheduledFlight();
  userDetails: User=new User();

  constructor(private _fMSService: FMSServiceService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
   // this.scheduledFlightId = parseInt(this.route.snapshot.paramMap.get('scheduledFlightId'))

    this.route.queryParams.subscribe(params => {
      //this.userDetails = JSON.parse(params.userDetails)
      this.scheduledFlight = JSON.parse(params.scheduledFlight)
    });
  }

  validatePassenger(passenger){
    console.log(passenger)
    this.router.navigate(['/finalBooking'],{
      queryParams:{
        userDetails:JSON.stringify(this.userDetails),
        scheduledFlight:JSON.stringify(this.scheduledFlight),
        passenger:JSON.stringify(passenger)}
    });
  }
}
