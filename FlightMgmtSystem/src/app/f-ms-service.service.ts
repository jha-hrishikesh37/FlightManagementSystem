import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

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

  public createBooking(booking: Object): Observable<any> {
    console.log("Services");
    return this.http.post(this.baseUrl + '/booking', booking);
  }
}
