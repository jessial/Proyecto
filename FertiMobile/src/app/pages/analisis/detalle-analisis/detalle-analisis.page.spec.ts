import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleAnalisisPage } from './detalle-analisis.page';

describe('DetalleAnalisisPage', () => {
  let component: DetalleAnalisisPage;
  let fixture: ComponentFixture<DetalleAnalisisPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalleAnalisisPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleAnalisisPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
