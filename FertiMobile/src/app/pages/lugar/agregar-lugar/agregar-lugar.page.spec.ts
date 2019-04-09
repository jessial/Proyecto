import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarLugarPage } from './agregar-lugar.page';

describe('AgregarLugarPage', () => {
  let component: AgregarLugarPage;
  let fixture: ComponentFixture<AgregarLugarPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgregarLugarPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgregarLugarPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
