import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Employee } from '../../model/employee';
import { HttpClient } from '@angular/common/http';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-list',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent implements OnInit{

empList: Employee[] = []

  constructor(private http:HttpClient,private service:EmployeeService){}

  ngOnInit(): void {
   this.getEmployees();
  }


  getEmployees(){
    return this.service.getEmployees().subscribe({
      next:(data:Employee[])=>{
        this.empList=data
        console.log(data)
      },
      error:(error)=>{
        console.log("no employees", error)
      }

    }) 
  }
  successMessage: string = '';

  deleteEmployee(id: number): void {

    const employee = this.empList.find(
      emp => emp.id === id
    );

    if (!employee) {
      return;
    }

    const confirmation = confirm(
      `Do you want to delete ${employee.name}?`
    );

    if (confirmation) {

      this.empList = this.empList.filter(
        emp => emp.id !== id
      );

      this.successMessage =
        `${employee.name} deleted successfully.`;
    }
  }
}