import { TestBed, inject } from '@angular/core/testing';

import { ParcelaService } from './parcela.service';

describe('ParcelaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ParcelaService]
    });
  });

  it('should be created', inject([ParcelaService], (service: ParcelaService) => {
    expect(service).toBeTruthy();
  }));
});
