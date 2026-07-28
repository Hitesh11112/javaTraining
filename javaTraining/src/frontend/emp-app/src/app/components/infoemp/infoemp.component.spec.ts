import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoempComponent } from './infoemp.component';

describe('InfoempComponent', () => {
  let component: InfoempComponent;
  let fixture: ComponentFixture<InfoempComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InfoempComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoempComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
