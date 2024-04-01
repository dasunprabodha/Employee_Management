import { Injectable } from '@angular/core';
import { Employee } from '../employee';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class AddService {
  private apiUrl = 'http://localhost:8080/emp/api/v1/employee';

  
  constructor(private http: HttpClient) {}

  saveEmployee(employee: Employee): Observable<void> {
    return this.http.post<void>(this.apiUrl, employee);
  }
}


