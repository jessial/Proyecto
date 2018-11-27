import { TestBed, inject } from '@angular/core/testing';

import { TipoFuenteService } from './tipo-fuente.service';

describe('TipoFuenteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TipoFuenteService]
    });
  });

  it('should be created', inject([TipoFuenteService], (service: TipoFuenteService) => {
    expect(service).toBeTruthy();
  }));
});
