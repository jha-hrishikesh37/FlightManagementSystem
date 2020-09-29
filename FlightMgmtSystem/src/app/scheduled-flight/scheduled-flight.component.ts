import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationServiceService } from '../authentication-service.service';
import { ScheduledFlight } from '../ScheduledFlight';
import { User } from '../User';

@Component({
  selector: 'app-scheduled-flight',
  templateUrl: './scheduled-flight.component.html',
  styleUrls: ['./scheduled-flight.component.css']
})
export class ScheduledFlightComponent implements OnInit {

  accountuserName = sessionStorage.getItem('userName')
  accountUsertype = sessionStorage.getItem('userType')
  accountUserid = sessionStorage.getItem('userid')

  userName = this.accountuserName
  userType = this.accountUsertype
  userid = +this.accountUserid
      
  isUserType= false;

  scheduleFlights: Observable<ScheduledFlight[]>;
  scheduledFlightId=0;
  user:User;
  sclFlight:ScheduledFlight;

  constructor(private _fMSService: AuthenticationServiceService,
    private router: Router,
    private route: ActivatedRoute) {}

    submitted=false;
  error=null;
  subId=true;

  ngOnInit(): void {
    console.log("Hello")
    this._fMSService.showScheduleFlights().subscribe(
      (data:Observable<ScheduledFlight[]>)=>this.scheduleFlights=data);      
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
  
  showCouponsById() {
    this.submitted=true;
    this._fMSService.showFlightWithId(this.scheduledFlightId)
    .subscribe((data) => {
      console.log(data)
      this.sclFlight=data;
      this.submitted=true;
      console.log(this.sclFlight);
    }, error =>{ this.error=error;
      this.submitted=false
      console.log(error.error);
      this.error=error.error.message;
      alert(this.error)
      this.submitted=false;
     });
  }

  back() {
    this.submitted=false;
    this.subId=true;
  }
}
