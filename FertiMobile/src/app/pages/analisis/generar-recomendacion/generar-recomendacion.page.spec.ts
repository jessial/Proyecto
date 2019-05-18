import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerarRecomendacionPage } from './generar-recomendacion.page';

describe('GenerarRecomendacionPage', () => {
  let component: GenerarRecomendacionPage;
  let fixture: ComponentFixture<GenerarRecomendacionPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenerarRecomendacionPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenerarRecomendacionPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
