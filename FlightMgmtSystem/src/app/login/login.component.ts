import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FMSServiceService } from '../f-ms-service.service';
import { User } from '../User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User=new User();
  // user:User={
  //   userId:0,
  //   userType:"",
  //   userName:"",
  //   password:"",
  //   phoneNumber:"",
  //   email:""
  // }

  invalidLogin = false;

  constructor(private router: Router, public loginService:FMSServiceService) { }

  ngOnInit(): void {
  }

  checkLogin(userName,password) {
    console.log(userName);
    console.log(password);

    this.loginService.authenticate(userName, password).subscribe (
      res=>{
        console.log(res);
        if(res!=null) {
          // sessionStorage.setItem('username', res.userName);
          // sessionStorage.setItem('userType', res.userType);
          sessionStorage.setItem('userid', res.userId+"");
          this.invalidLogin = false;
          this.router.navigate(['home']);
        }
        else {
          alert('Invalid credentials!! Please enter correct details');
        }
      }
    );
  }
}
