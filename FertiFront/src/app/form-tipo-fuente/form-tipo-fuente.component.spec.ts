import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormTipoFuenteComponent } from './form-tipo-fuente.component';

describe('FormTipoFuenteComponent', () => {
  let component: FormTipoFuenteComponent;
  let fixture: ComponentFixture<FormTipoFuenteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormTipoFuenteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormTipoFuenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
