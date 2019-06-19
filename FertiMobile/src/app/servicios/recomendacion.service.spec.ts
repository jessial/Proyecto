/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { RecomendacionService } from './recomendacion.service';

describe('Service: Recomendacion', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RecomendacionService]
    });
  });

  it('should ...', inject([RecomendacionService], (service: RecomendacionService) => {
    expect(service).toBeTruthy();
  }));
});
