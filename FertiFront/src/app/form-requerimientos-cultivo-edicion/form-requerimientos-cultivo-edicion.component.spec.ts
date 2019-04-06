import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormRequerimientosCultivoEdicionComponent } from './form-requerimientos-cultivo-edicion.component';

describe('FormRequerimientosCultivoEdicionComponent', () => {
  let component: FormRequerimientosCultivoEdicionComponent;
  let fixture: ComponentFixture<FormRequerimientosCultivoEdicionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormRequerimientosCultivoEdicionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormRequerimientosCultivoEdicionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
