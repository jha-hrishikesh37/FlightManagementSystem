import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Booking } from './Booking';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class FMSServiceService {

  private baseUrl = 'http://localhost:9091/fms/user';

  constructor(private http: HttpClient) {}
  
  public registerUser(user: Object): Observable<any> {
    return this.http.post(this.baseUrl + '/registerUser', user);
  }

  public showScheduleFlights(): Observable<any> {
    return this.http.get(this.baseUrl+'/viewAllScheduledFlights');
  }

  public createBooking(booking: Booking): Observable<any> {
    console.log("Services");
    console.log(booking);
    return this.http.post(this.baseUrl + '/finalBooking', booking);

  }


  authenticate(userName,password): Observable<any> {
    return this.http.post<User>(this.baseUrl+"/doLogin", userName,password);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log(user);
    console.log(!(user === null))
    return !(user === null)
  }
}


