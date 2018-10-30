import { TestBed, inject } from '@angular/core/testing';

import { RequerimientoCultivoService } from './requerimiento-cultivo.service';

describe('RequerimientoCultivoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RequerimientoCultivoService]
    });
  });

  it('should be created', inject([RequerimientoCultivoService], (service: RequerimientoCultivoService) => {
    expect(service).toBeTruthy();
  }));
});
