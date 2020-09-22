import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { FMSServiceService } from '../f-ms-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userDetails:User=new User();
  
  constructor(private _fMSService: FMSServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }

  validateUser(){
    console.log("Happy");
    this._fMSService.registerUser(this.userDetails)
        .subscribe((error) => console.log(error));
  }

}