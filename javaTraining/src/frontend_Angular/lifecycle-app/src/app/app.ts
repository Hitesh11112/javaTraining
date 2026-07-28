import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Demo } from "./demo/demo";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Demo],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('lifecycle-app');
  name = "hitesh";

  changeName(): void {
    this.name = "Hitesh Patwal";
  }

  resetName(): void {
    this.name = "Dinesh Patwl";
  }

}
