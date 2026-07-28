import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Hello } from './components/hello/hello';
import { Login } from "./components/login/login";
import { Employee } from "./components/employee/employee";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Hello, Login, Employee],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = 'my-app';

}
