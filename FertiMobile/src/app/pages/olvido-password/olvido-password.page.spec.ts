import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OlvidoPasswordPage } from './olvido-password.page';

describe('OlvidoPasswordPage', () => {
  let component: OlvidoPasswordPage;
  let fixture: ComponentFixture<OlvidoPasswordPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OlvidoPasswordPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OlvidoPasswordPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
