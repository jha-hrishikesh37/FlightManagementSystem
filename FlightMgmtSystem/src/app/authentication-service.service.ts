import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { User } from './User';
import { Booking } from './Booking';

import { BookingDetails } from './BookingDetails';
import { ScheduledFlightComponent } from './scheduled-flight/scheduled-flight.component';
import { ScheduledFlight } from './ScheduledFlight';
import { Airport } from './Airport';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  private baseUrl = 'http://localhost:9091/fms/user';

  constructor(private http: HttpClient) {}

  handleError(error){
    let errorMessage='';
    if(error.error instanceof ErrorEvent){
      errorMessage='Error:${error.errorMessage}';
      console.log("Client Side");
    }
    else{
      errorMessage='Error:${error.errorMessage}';
      console.log("Server Side");
    }
    console.log(error.error.errorMessage);
    return throwError(error);
  }
  
  public registerUser(user: Object): Observable<any> {
    return this.http.post(this.baseUrl + '/registerUser', user);
  }

  authenticate(user:User): Observable<User> {
    return this.http.post<User>(this.baseUrl+"/doLogin", user);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    return !(user === null)
  }

  user:User;

  getUser() {
    return this.http.get<User[]>(this.baseUrl+"/");
  }

  public findUser(id:number): Observable<any> {
    console.log("In services");
    return this.http.get(`${this.baseUrl}/find/${id}`);
  }

  public findSAFlight(src:Airport,dest:Airport): Observable<ScheduledFlight> {
    return this.http.get<ScheduledFlight>(`${this.baseUrl}/viewSAFlight/${src}/${dest}`)
    .pipe(catchError(this.handleError));
  }

  addFlight(flight: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/addFlight`, flight);
  }

  public showFlightWithId(flightNumber:number): Observable<ScheduledFlight>{
    console.log(flightNumber);
    return this.http.get<ScheduledFlight>(`${this.baseUrl}/viewScheduledFlight/${flightNumber}`);
  }

  public showScheduleFlights(): Observable<any> {
    return this.http.get(this.baseUrl+'/viewAllScheduledFlights');
  }

  public createBooking(booking: Booking): Observable<any> {
    console.log("Services");

    return this.http.post(this.baseUrl + '/finalBooking', booking);

  }

  getAllBookings():Observable<any>{
    return this.http.get(`${this.baseUrl}/readAllBooking`)
  }
  
  getBooking(bookingId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/searchBooking/${bookingId}`);
  }

  updateBooking(booking: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/updateBooking`, booking);
  }

  deleteBooking(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteBooking/${id}`, {responseType: 'text'});
  }

  logOut() {
    sessionStorage.removeItem('userName');
  }
}
