import { Component } from '@angular/core';

@Component({
  selector: 'app-hello',
  imports: [],
  templateUrl: './hello.html',
  styleUrl: './hello.css',
})
export class Hello {

  msg="Hello"
  color="blue"
  fontSize=40
  borderStyle="3px solid black";
  textColor="Red"
  isDisabled=true
  source = "https://upload.wikimedia.org/wikipedia/commons/3/3f/Fronalpstock_big.jpg";


  changeColor():void {
    this.color=(this.color==="blue"?"green":"blue");
  }

  changeBorder(): void {
  this.borderStyle =
    (this.borderStyle === "3px solid black")
      ? "5px dotted red"
      : "3px solid black";
}
  //change border of paragraph based on button click
  //1. 3px solid black
  //2. 5px dotted yellow
}
