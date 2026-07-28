import { Component } from '@angular/core';
import { Employee } from '../../model/employee';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-addemp',
  imports: [FormsModule,CommonModule],
  templateUrl: './addemp.component.html',
  styleUrl: './addemp.component.css'
})
export class AddempComponent {

 emp:Employee=new Employee();

 constructor(private service:EmployeeService){}


 addEmployee(){
  
    this.service.addEmployee(this.emp).subscribe((data)=>{
        console.log("employee added", this.emp)
    })
 }

}
