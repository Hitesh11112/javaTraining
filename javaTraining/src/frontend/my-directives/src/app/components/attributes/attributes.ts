import { Component } from '@angular/core';
import { NgClass, NgStyle } from '@angular/common';

@Component({
  selector: 'app-attributes',
  imports: [NgClass, NgStyle],
  templateUrl: './attributes.html',
  styleUrl: './attributes.css',
})
export class Attributes {

  isRed = true;

  color = 'blue';

  size = '40px';

}
