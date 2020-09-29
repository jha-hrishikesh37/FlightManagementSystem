import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationServiceService } from '../authentication-service.service';
import { User } from '../User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user:User=new User();
  error=null;
message="";
  constructor(public loginService:AuthenticationServiceService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  validateUser(){
    this.loginService.registerUser(this.user)
        .subscribe((data) => {
          console.log(data)
          this.router.navigate(['/login'],{
            queryParams:{
              userDetails:JSON.stringify(this.user)}
          });
        }, error =>{ this.error=error;
          console.log(error.error.message);
          this.error=error.error.message;
          this.router.navigate(['/signup']);
          alert(this.error);
         });

        
  }
}

