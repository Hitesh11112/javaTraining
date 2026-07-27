import { Component, OnChanges, OnInit, DoCheck, AfterContentInit, AfterContentChecked, AfterViewInit, AfterViewChecked, OnDestroy, SimpleChanges, Input } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.html',
  styleUrl: './demo.css',
})
export class Demo implements OnChanges, OnInit, DoCheck, AfterContentInit, AfterContentChecked, AfterViewInit, AfterViewChecked, OnDestroy {

  @Input() myname = '';

  constructor() {
    console.log('0. constructor');
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('1. ngOnChanges');
    if (changes['myname']) {
      console.log('Previous value:', changes['myname'].previousValue);
      console.log('Current value:', changes['myname'].currentValue);
    }
  }

  ngOnInit(): void {
    console.log('2. ngOnInit');
  }

  ngDoCheck(): void {
    console.log('3. ngDoCheck');
  }

  ngAfterContentInit(): void {
    console.log('4. ngAfterContentInit');
  }

  ngAfterContentChecked(): void {
    console.log('5. ngAfterContentChecked');
  }

  ngAfterViewInit(): void {
    console.log('6. ngAfterViewInit');
  }

  ngAfterViewChecked(): void {
    console.log('7. ngAfterViewChecked');
  }

  ngOnDestroy(): void {
    console.log('8. ngOnDestroy');
  }
}
