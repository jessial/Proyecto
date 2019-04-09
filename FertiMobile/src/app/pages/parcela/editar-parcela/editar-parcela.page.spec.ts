import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarParcelaPage } from './editar-parcela.page';

describe('EditarParcelaPage', () => {
  let component: EditarParcelaPage;
  let fixture: ComponentFixture<EditarParcelaPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditarParcelaPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarParcelaPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
