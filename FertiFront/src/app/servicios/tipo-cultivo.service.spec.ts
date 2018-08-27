import { TestBed, inject } from '@angular/core/testing';

import { TipoCultivoService } from './tipo-cultivo.service';

describe('TipoCultivoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TipoCultivoService]
    });
  });

  it('should be created', inject([TipoCultivoService], (service: TipoCultivoService) => {
    expect(service).toBeTruthy();
  }));
});
