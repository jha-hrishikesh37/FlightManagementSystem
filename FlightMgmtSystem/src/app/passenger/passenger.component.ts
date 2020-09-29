import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationExtras, Router } from '@angular/router';
import { AuthenticationServiceService } from '../authentication-service.service';
import { Passenger } from '../Passenger';
import { ScheduledFlight } from '../ScheduledFlight';
import { User } from '../User';

@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})
export class PassengerComponent implements OnInit {

  user:User=new User()
  accountuserName = sessionStorage.getItem('userName');
  userName = this.accountuserName;

  scheduledFlight:ScheduledFlight=new ScheduledFlight();
  passengerDetails:Passenger=new Passenger();

  constructor(public loginService:AuthenticationServiceService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    
  }

  validatePassenger(passenger){
    console.log(passenger)
    this.router.navigate(['/booking'],{
      queryParams:{
        passenger:JSON.stringify(passenger)}
    });
  }
}

