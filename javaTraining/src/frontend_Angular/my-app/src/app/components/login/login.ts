import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  email:string='' ;
  pwd:string='' ;

  doLogin(): void {
    if(this.email==="hitesh@com" && this.pwd==="hitesh") {
      alert("Login successful");
    } else {
      alert("Invalid credentials");
    }
  }
  // homework
  // Add employee
  // Ename Eid Salary Email MobileNo. Button ... total 5 properties
  // print data in the console
  // form in the middle of the screen

}
