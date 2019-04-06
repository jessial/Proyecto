import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormTipoFuenteEdicionComponent } from './form-tipo-fuente-edicion.component';

describe('FormTipoFuenteEdicionComponent', () => {
  let component: FormTipoFuenteEdicionComponent;
  let fixture: ComponentFixture<FormTipoFuenteEdicionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormTipoFuenteEdicionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormTipoFuenteEdicionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
