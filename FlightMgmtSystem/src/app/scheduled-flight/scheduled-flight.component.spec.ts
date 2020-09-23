import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduledFlightComponent } from './scheduled-flight.component';

describe('ScheduledFlightComponent', () => {
  let component: ScheduledFlightComponent;
  let fixture: ComponentFixture<ScheduledFlightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduledFlightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduledFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
