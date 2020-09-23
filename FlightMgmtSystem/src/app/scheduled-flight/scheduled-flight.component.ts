import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FMSServiceService } from '../f-ms-service.service';
import { ScheduledFlight } from '../scheduledFlight';
import { User } from '../User';

@Component({
  selector: 'app-scheduled-flight',
  templateUrl: './scheduled-flight.component.html',
  styleUrls: ['./scheduled-flight.component.css']
})
export class ScheduledFlightComponent implements OnInit {

  scheduleFlights: Observable<ScheduledFlight[]>;
  scheduledFlightId=0;
  userDetails:User;

  constructor(private _fMSService: FMSServiceService,
    private router: Router,
    private route: ActivatedRoute) {}

  ngOnInit(): void {
    console.log("Hello")
    this._fMSService.showScheduleFlights().subscribe(
      (data:Observable<ScheduledFlight[]>)=>this.scheduleFlights=data);

      // this.route.queryParams.subscribe(params => {
      //   this.userDetails = JSON.parse(params.userDetails)
      // });
      
  }

  add(schedeuledFlights){
    this.router.navigate(['/passenger'],{
      queryParams:{
        userDetails:JSON.stringify(this.userDetails),
        scheduledFlight: JSON.stringify(this.scheduleFlights)
      }
    });
   console.log("OKs"+this.scheduleFlights)
  }
}

