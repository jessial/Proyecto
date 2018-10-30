import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormRequerimientosCultivoComponent } from './form-requerimientos-cultivo.component';

describe('FormRequerimientosCultivoComponent', () => {
  let component: FormRequerimientosCultivoComponent;
  let fixture: ComponentFixture<FormRequerimientosCultivoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormRequerimientosCultivoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormRequerimientosCultivoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
