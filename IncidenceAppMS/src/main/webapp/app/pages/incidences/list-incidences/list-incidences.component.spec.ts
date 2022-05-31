import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListIncidencesComponent } from './list-incidences.component';

describe('ListIncidencesComponent', () => {
  let component: ListIncidencesComponent;
  let fixture: ComponentFixture<ListIncidencesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListIncidencesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListIncidencesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
