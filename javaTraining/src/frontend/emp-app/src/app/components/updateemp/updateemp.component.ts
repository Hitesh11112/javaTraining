import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Employee } from '../../model/employee';

@Component({
  selector: 'app-updateemp',
  imports: [ReactiveFormsModule],
  templateUrl: './updateemp.component.html',
  styleUrl: './updateemp.component.css'
})
export class UpdateempComponent {

  updateForm!:FormGroup;
  empid!:number;

  empList:Employee[]= [{id:123,name:"swapna",desg:"trainer"},
    {id:122,name:"swathi",desg:"Developer"},
    {id:124,name:"swetha",desg:"Programmer"},
    {id:121,name:"sruthi",desg:"Manager"},
    {id:125,name:"srujana",desg:"Account"},
  ]

  constructor(private fb: FormBuilder) {

    this.updateForm = this.fb.group({

      id: [

        { value: 101, disabled: true }

      ],

      name: [

        'Swapna',

        [

          Validators.required,

          Validators.minLength(3),

          Validators.maxLength(30),

          Validators.pattern('[a-zA-Z ]*')

        ]

      ],

      desg: [

        'Trainer',

        [

          Validators.required,

          Validators.minLength(2),

          Validators.maxLength(30),

          Validators.pattern('[a-zA-Z ]*')

        ]

      ]

    });

  }

  updateEmployee() {

    console.log(this.updateForm.getRawValue());

    alert("Employee Updated Successfully");

  }

  cancel() {

    alert("Update Cancelled");

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


