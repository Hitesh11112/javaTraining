import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Attributes } from "./components/attributes/attributes";
import { Structural } from "./components/structural/structural";
import { Child } from './child/child';
import { Parent } from './parent/parent';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Attributes, Structural,Parent,Child],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('my-directives');
}
