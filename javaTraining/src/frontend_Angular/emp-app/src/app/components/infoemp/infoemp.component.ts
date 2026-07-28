import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-infoemp',
  imports: [RouterLink],
  templateUrl: './infoemp.component.html',
  styleUrl: './infoemp.component.css'
})
export class InfoempComponent implements OnInit {

  employee?: Employee;

  constructor(
    private activatedRoute: ActivatedRoute,
    private service: EmployeeService
  ) {}

  ngOnInit(): void {

    const id = Number(this.activatedRoute.snapshot.paramMap.get('id')) ?? '';

    this.service.getEmployeeById(id).subscribe({
      next: (employee: Employee) => {
        this.employee = employee;
      },
      error: (error) => {
        console.log("could not load employee", error);
        this.employee = undefined;
      }
    });

  }
}
