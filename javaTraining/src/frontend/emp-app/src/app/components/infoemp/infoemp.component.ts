import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Employee } from '../../model/employee';

@Component({
  selector: 'app-infoemp',
  imports: [RouterLink],
  templateUrl: './infoemp.component.html',
  styleUrl: './infoemp.component.css'
})
export class InfoempComponent {

  employee?: Employee;

  empList: Employee[] = [

    {

      id: 123,

      name: 'Swapna',

      desg: 'Trainer'

    },

    {

      id: 122,

      name: 'Swathi',

      desg: 'Developer'

    },

    {

      id: 124,

      name: 'Swetha',

      desg: 'Programmer'

    },

    {

      id: 121,

      name: 'Sruthi',

      desg: 'Manager'

    },

    {

      id: 125,

      name: 'Srujana',

      desg: 'Accountant'

    }

  ];

  constructor(

    private activatedRoute: ActivatedRoute

  ) {}

  ngOnInit(): void {

    const id = Number(

      this.activatedRoute.snapshot.paramMap.get('id')

    );

    this.employee = this.empList.find(

      emp => emp.id === id

    );

  
  }
}
