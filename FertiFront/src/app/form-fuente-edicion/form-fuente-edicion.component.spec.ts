import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFuenteEdicionComponent } from './form-fuente-edicion.component';

describe('FormFuenteEdicionComponent', () => {
  let component: FormFuenteEdicionComponent;
  let fixture: ComponentFixture<FormFuenteEdicionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormFuenteEdicionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormFuenteEdicionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
