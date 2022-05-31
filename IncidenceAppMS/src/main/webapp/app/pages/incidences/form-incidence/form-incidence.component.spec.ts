import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormIncidenceComponent } from './form-incidence.component';

describe('FormIncidenceComponent', () => {
  let component: FormIncidenceComponent;
  let fixture: ComponentFixture<FormIncidenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormIncidenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormIncidenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
