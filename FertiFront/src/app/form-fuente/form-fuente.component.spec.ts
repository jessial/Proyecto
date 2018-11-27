import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFuenteComponent } from './form-fuente.component';

describe('FormFuenteComponent', () => {
  let component: FormFuenteComponent;
  let fixture: ComponentFixture<FormFuenteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormFuenteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormFuenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
