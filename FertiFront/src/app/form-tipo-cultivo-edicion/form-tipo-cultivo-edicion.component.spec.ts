import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormTipoCultivoEdicionComponent } from './form-tipo-cultivo-edicion.component';

describe('FormTipoCultivoEdicionComponent', () => {
  let component: FormTipoCultivoEdicionComponent;
  let fixture: ComponentFixture<FormTipoCultivoEdicionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormTipoCultivoEdicionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormTipoCultivoEdicionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
