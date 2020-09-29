import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from '../authentication-service.service';
import { User } from '../User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User=new User();

  invalidLogin = false;

  constructor(private router: Router, public loginService:AuthenticationServiceService) { }

  ngOnInit(): void {
  }

  checkLogin() {

    this.loginService.authenticate(this.user).subscribe (
      res=>{
        console.log(res);
        if(res!=null) {
          sessionStorage.setItem('userid', res.userid+"");
          sessionStorage.setItem('userType', res.userType+"");
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
