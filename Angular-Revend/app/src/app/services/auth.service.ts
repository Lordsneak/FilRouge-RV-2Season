import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(data: { username: String , password : String } ) {
    return this.http.post("http://localhost:8080/login", data);
  }

}
