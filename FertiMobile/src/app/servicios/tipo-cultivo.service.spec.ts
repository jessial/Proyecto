import { TestBed } from '@angular/core/testing';

import { TipoCultivoService } from './tipo-cultivo.service';

describe('TipoCultivoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TipoCultivoService = TestBed.get(TipoCultivoService);
    expect(service).toBeTruthy();
  });
});
