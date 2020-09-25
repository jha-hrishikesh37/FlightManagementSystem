import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { FMSServiceService } from '../f-ms-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user:User=new User();
  
  constructor(private _fMSService: FMSServiceService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  validateUser(){
    console.log("Happy");
    this._fMSService.registerUser(this.user)
        .subscribe((error) => console.log(error));

        this.router.navigate(['/allFlights'],{
          queryParams:{
            userDetails:JSON.stringify(this.user)}
        });
  }

}