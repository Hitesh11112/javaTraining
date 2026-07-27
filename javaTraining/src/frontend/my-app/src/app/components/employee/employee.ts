import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee',
  imports: [FormsModule, CommonModule],
  templateUrl: './employee.html',
  styleUrl: './employee.css',
})
export class Employee {

  eName: string = "";
  eId: number = 0;
  salary: number = 0;
  email: string = "";
  mobileNo: string = "";

  addEmployee(): void {
    console.log("Employee Name :", this.eName);
    console.log("Employee ID   :", this.eId);
    console.log("Salary        :", this.salary);
    console.log("Email         :", this.email);
    console.log("Mobile No     :", this.mobileNo);
  }

}
