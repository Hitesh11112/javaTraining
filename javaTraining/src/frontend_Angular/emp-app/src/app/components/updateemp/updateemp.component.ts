import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-updateemp',
  imports: [ReactiveFormsModule],
  templateUrl: './updateemp.component.html',
  styleUrl: './updateemp.component.css'
})
export class UpdateempComponent implements OnInit {

  updateForm!: FormGroup;
  empId!: number;

  constructor(
    private fb: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private service: EmployeeService
  ) {

    this.updateForm = this.fb.group({

      id: [
        { value: '', disabled: true }
      ],

      name: [
        '',
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(30),
          Validators.pattern('[a-zA-Z ]*')
        ]
      ],

      desg: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(30),
          Validators.pattern('[a-zA-Z ]*')
        ]
      ]

    });

  }

  ngOnInit(): void {

    this.empId = Number(this.activatedRoute.snapshot.paramMap.get('id')) ?? '';

    this.service.getEmployeeById(this.empId).subscribe({
      next: (employee: Employee) => {
        this.updateForm.patchValue({
          id: employee.id,
          name: employee.name,
          desg: employee.desg
        });
      },
      error: (error) => {
        console.log("could not load employee", error);
      }
    });
  }

  updateEmployee() {

    const updatedEmployee: Employee = {
      id: this.empId,
      name: this.updateForm.getRawValue().name,
      desg: this.updateForm.getRawValue().desg
    };

    this.service.updateEmployee(this.empId, updatedEmployee).subscribe({
      next: () => {
        alert("Employee Updated Successfully");
        this.router.navigate(['/list']);
      },
      error: (error) => {
        console.log("could not update employee", error);
      }
    });

  }

  cancel() {
    this.router.navigate(['/list']);
  }

  get id() {
    return this.updateForm.get('id');
  }

  get name() {
    return this.updateForm.get('name');
  }

  get desg() {
    return this.updateForm.get('desg');
  }

}
