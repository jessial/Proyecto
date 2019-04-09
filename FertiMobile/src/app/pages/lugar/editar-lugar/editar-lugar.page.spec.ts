import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarLugarPage } from './editar-lugar.page';

describe('EditarLugarPage', () => {
  let component: EditarLugarPage;
  let fixture: ComponentFixture<EditarLugarPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditarLugarPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarLugarPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
