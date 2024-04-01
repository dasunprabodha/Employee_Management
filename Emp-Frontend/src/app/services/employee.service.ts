import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiUrl = 'http://localhost:8080/emp/api/v1/employee';

  constructor(private http: HttpClient) {}

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.apiUrl);
  }

  deleteEmployee(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  saveEmployee(employee: Employee): Observable<void> {
    return this.http.post<void>(this.apiUrl, employee);
  }

  updateEmployee(employee: Employee): Observable<void> {
    return this.http.patch<void>(`${this.apiUrl}/${employee.id}`, employee);
  }
}