import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationServiceService } from '../authentication-service.service';
import { Flight } from '../Flight';
import { User } from '../User';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {
  accountUsername = sessionStorage.getItem('username')
  accountUsertype = sessionStorage.getItem('userType')
  accountUserid = sessionStorage.getItem('userid')

  username = this.accountUsername
  userType = this.accountUsertype
  userid = +this.accountUserid

  isUserType= false;

  user:User=new User()

  flight : Flight =new Flight();
  submitted=false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private loginService: AuthenticationServiceService,
    ) { }


  ngOnInit() {
    this.loginService.findUser(this.userid).subscribe(data => this.user = data);

    if(this.userType === "Admin" || this.userType === "admin") {
      this.isUserType = true;
    }
  }

  newFlight(): void{
    this.submitted=false;
    this.flight=new Flight();
  }
  save() {
    this.loginService.addFlight(this.flight)
      .subscribe(data => console.log(data), error => console.log(error));
    this.flight= new Flight();
    this.router.navigate(['/login']);
  }

  onSubmit() {
    this.submitted=true;
    this.save();
  }

}
