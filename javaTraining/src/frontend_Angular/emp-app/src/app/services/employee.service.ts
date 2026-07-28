import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

// const BASE_URL="http://localhost:3000/employees"
const BASE_URL="http://localhost:8081/api/employees"
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  getEmployees():Observable<Employee[]>{
    return this.http.get<Employee[]>(BASE_URL);
  }

  addEmployee(employee:Employee):Observable<any>{
    return this.http.post<any>(BASE_URL,employee)
  }

  getEmployeeById(id:number):Observable<Employee>{
    return this.http.get<Employee>(`${BASE_URL}/${id}`);
  }

  updateEmployee(id:number, employee:Employee):Observable<any>{
    return this.http.put<any>(`${BASE_URL}/${id}`, employee);
  }

  deleteEmployee(id:number):Observable<any>{
    return this.http.delete<any>(`${BASE_URL}/${id}`);
  }

}
