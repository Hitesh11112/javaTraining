import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebearComponent } from './sidebear.component';

describe('SidebearComponent', () => {
  let component: SidebearComponent;
  let fixture: ComponentFixture<SidebearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SidebearComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SidebearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
