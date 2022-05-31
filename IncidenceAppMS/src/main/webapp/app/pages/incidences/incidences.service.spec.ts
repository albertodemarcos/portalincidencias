import { TestBed } from '@angular/core/testing';

import { IncidencesService } from './incidences.service';

describe('IncidencesService', () => {
  let service: IncidencesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IncidencesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
