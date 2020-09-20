import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FMSServiceService {

  private baseUrl = 'http://localhost:9091/bootcamp/user';

  constructor(private http: HttpClient) {}
  
  public registerUser(user: Object): Observable<any> {
    return this.http.post(this.baseUrl + '/registerUser', user);
  }
}
