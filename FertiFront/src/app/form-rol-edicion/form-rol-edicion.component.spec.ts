import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormRolEdicionComponent } from './form-rol-edicion.component';

describe('FormRolEdicionComponent', () => {
  let component: FormRolEdicionComponent;
  let fixture: ComponentFixture<FormRolEdicionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormRolEdicionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormRolEdicionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
