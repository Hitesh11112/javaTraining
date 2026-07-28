import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-structural',
  imports: [CommonModule],
  templateUrl: './structural.html',
  styleUrl: './structural.css',
})
export class Structural {
  // isLoggedIn=false;

  // checkLogin() {
  //   this.isLoggedIn=!this.isLoggedIn
  // }

  role='student'
  student=[
    {id:1,name:"Hitesh",course:"Java"},
    {id:2,name:"Ram",course:"C++"},
    {id:3,name:"Shyaam",course:"Python"}
  ]


  changeRole(role:string) {
    this.role=role;
  }
}
