import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewIncidenceComponent } from './view-incidence.component';

describe('ViewIncidenceComponent', () => {
  let component: ViewIncidenceComponent;
  let fixture: ComponentFixture<ViewIncidenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewIncidenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewIncidenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
