import { TestBed } from '@angular/core/testing';

import { FuenteService } from './fuente.service';

describe('FuenteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FuenteService = TestBed.get(FuenteService);
    expect(service).toBeTruthy();
  });
});
