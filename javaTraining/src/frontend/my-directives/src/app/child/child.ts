import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  imports: [],
  templateUrl: './child.html',
  styleUrl: './child.css',
})
export class Child {

  @Input()
  uname: string = '';

  @Output()
  message = new EventEmitter<string>();

  sendMsgParent() {
    this.message.emit("Hello Parent");
  }

}
