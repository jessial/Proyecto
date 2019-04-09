import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParcelaPage } from './parcela.page';

describe('ParcelaPage', () => {
  let component: ParcelaPage;
  let fixture: ComponentFixture<ParcelaPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParcelaPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParcelaPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
