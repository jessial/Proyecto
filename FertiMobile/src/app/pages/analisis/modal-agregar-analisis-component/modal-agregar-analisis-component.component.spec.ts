/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { ModalAgregarAnalisisComponentComponent } from './modal-agregar-analisis-component.component';

describe('ModalAgregarAnalisisComponentComponent', () => {
  let component: ModalAgregarAnalisisComponentComponent;
  let fixture: ComponentFixture<ModalAgregarAnalisisComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalAgregarAnalisisComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalAgregarAnalisisComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
