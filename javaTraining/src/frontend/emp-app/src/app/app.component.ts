import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SidebearComponent } from "./components/sidebear/sidebear.component";
import { AddempComponent } from "./components/addemp/addemp.component";
import { ListComponent } from "./components/list/list.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SidebearComponent, AddempComponent, ListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'emp-app';
}
