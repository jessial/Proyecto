import { TestBed, inject } from '@angular/core/testing';

import { UtilidadService } from './utilidad.service';

describe('UtilidadService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UtilidadService]
    });
  });

  it('should be created', inject([UtilidadService], (service: UtilidadService) => {
    expect(service).toBeTruthy();
  }));
});
