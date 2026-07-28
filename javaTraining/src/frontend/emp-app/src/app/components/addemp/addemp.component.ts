import { Component } from '@angular/core';
import { Employee } from '../../model/employee';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-addemp',
  imports: [FormsModule,CommonModule],
  templateUrl: './addemp.component.html',
  styleUrl: './addemp.component.css'
})
export class AddempComponent {

 emp:Employee=new Employee();


 idTakenError:boolean = false;
 checkingId:boolean = false;

 constructor(private service:EmployeeService, private router:Router){}


 addEmployee(){

    this.idTakenError = false;
    this.checkingId = true;

    // check if an employee with this id already exists before creating
    this.service.getEmployeeById(this.emp.id).subscribe({
      next: () => {
        // an employee with this id was found -> id is taken
        this.checkingId = false;
        this.idTakenError = true;
      },
      error: (error) => {
        this.checkingId = false;

        if (error.status !== 404) {
          console.log("could not verify employee id", error);
          return;
        }

        // id not found -> safe to create
        this.service.addEmployee(this.emp).subscribe({
          next: () => {
            console.log("employee added", this.emp)
            this.router.navigate(['/list']);
          },
          error: (error) => {
            console.log("could not add employee", error)
          }
        })
      }
    });
 }

}
